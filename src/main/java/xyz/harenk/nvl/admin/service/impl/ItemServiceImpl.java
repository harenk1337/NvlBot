package xyz.harenk.nvl.admin.service.impl;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.bean.copier.CopyOptions;
import cn.hutool.core.collection.CollUtil;
import cn.hutool.core.util.ObjectUtil;
import cn.hutool.core.util.StrUtil;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import xyz.harenk.nvl.admin.domain.PageResult;
import xyz.harenk.nvl.admin.domain.entity.ItemEntity;
import xyz.harenk.nvl.admin.domain.req.ItemPageQueryDTO;
import xyz.harenk.nvl.admin.domain.req.ItemUpsertDTO;
import xyz.harenk.nvl.admin.mapper.ItemMapper;
import xyz.harenk.nvl.admin.service.IItemService;
import xyz.harenk.nvl.common.exceptions.BizException;
import xyz.harenk.nvl.common.utils.PageUtils;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

/**
 * @author harenk.xyz @harenk1337
 * @description
 * @create 2024-05-29 17:39
 */
@Service
public class ItemServiceImpl extends ServiceImpl<ItemMapper, ItemEntity> implements IItemService {
    @Override
    public PageResult<ItemEntity> pageQueryItem(ItemPageQueryDTO pageQueryDTO) {
        Page<ItemEntity> page = new Page<>(pageQueryDTO.getPage(), pageQueryDTO.getPageSize());
        LambdaQueryWrapper<ItemEntity> queryWrapper = Wrappers.<ItemEntity>lambdaQuery()
                .like(ObjectUtil.isNotEmpty(pageQueryDTO.getName()), ItemEntity::getName, pageQueryDTO.getName())
                .orderByAsc(ItemEntity::getId);

        Page<ItemEntity> itemEntityPage = this.page(page, queryWrapper);
        return PageUtils.toPage(itemEntityPage);
    }

    @Override
    public void upsert(ItemUpsertDTO itemUpsertDTO) {
        if (ObjectUtil.isNull(itemUpsertDTO.getId())) {
            insertItem(itemUpsertDTO);
        } else {
            updateItem(itemUpsertDTO);
        }
    }

    private void insertItem(ItemUpsertDTO itemUpsertDTO) {
        ItemEntity i = lambdaQuery().eq(ItemEntity::getName, itemUpsertDTO.getName()).one();
        if (ObjectUtil.isNotNull(i)) {
            throw new BizException(StrUtil.format("项目名 {} 已存在！", itemUpsertDTO.getName()));
        }

        ItemEntity item = BeanUtil.toBean(itemUpsertDTO, ItemEntity.class, CopyOptions.create().ignoreNullValue());
        boolean save = this.save(item);
        if (!save) {
            throw new BizException(StrUtil.format("新增项目 {} 失败！", item.getName()));
        }
    }

    private void updateItem(ItemUpsertDTO itemUpsertDTO) {
        ItemEntity item = Optional.ofNullable(this.getById(itemUpsertDTO.getId()))
                .orElseThrow(() -> new BizException("用户不存在！"));

        ItemEntity i = lambdaQuery().eq(ItemEntity::getName, itemUpsertDTO.getName()).one();
        if (ObjectUtil.notEqual(i, item)) {
            throw new BizException(StrUtil.format("项目名 {} 已存在！", itemUpsertDTO.getName()));
        }

        BeanUtil.copyProperties(itemUpsertDTO, item, CopyOptions.create().ignoreNullValue());
        int row = baseMapper.updateById(item);
        if (row <= 0) {
            throw new BizException(StrUtil.format("更新项目 {} 失败！", item.getName()));
        }
    }

    @Override
    public void deleteById(Long id) {
        long count = this.count(new LambdaQueryWrapper<ItemEntity>().eq(ItemEntity::getId, id));
        if (count <= 0) {
            throw new BizException("项目不存在!");
        }
        boolean b = this.removeById(id);
        if (!b) {
            throw new BizException("项目删除失败！");
        }
    }

    @Override
    public List<String> queryAllItemName() {
        List<ItemEntity> list = lambdaQuery().select(ItemEntity::getName).list();
        if (CollUtil.isEmpty(list)) {
            return Collections.emptyList();
        }
        return list.stream().map(ItemEntity::getName).toList();
    }
}
