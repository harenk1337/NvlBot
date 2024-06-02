package xyz.harenk.nvl.common.utils;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.map.MapUtil;
import cn.hutool.crypto.SecureUtil;
import cn.hutool.http.ContentType;
import cn.hutool.http.Header;
import cn.hutool.http.HttpRequest;
import cn.hutool.json.JSONUtil;
import xyz.harenk.nvl.admin.domain.req.MarketItemReqDTO;
import xyz.harenk.nvl.admin.domain.res.MarketResponse;

import java.util.Map;
import java.util.Objects;

/**
 * @author harenk.xyz @harenk1337
 * @description
 * @create 2024-05-31 18:34
 */
public class MarketUtils {

    private MarketUtils() {
    }

    private static final String URL = "https://en.neverlose.cc/api/market/give-for-free";

    public static String generateSign(Map<String, Object> map, String key) {
        map.remove("signature");
        MapUtil.sort(map);
        return SecureUtil.signParamsSha256(map, key);
    }

    public static <T> String generateSign(T obj, String key) {
        Map<String, Object> map = BeanUtil.beanToMap(obj, true, true);
        return generateSign(map, key);
    }

    public static <T> Boolean checkSign(T obj, String key) {
        Map<String, Object> map = BeanUtil.beanToMap(obj, true, true);
        String signature = map.get("signature").toString();
        return Objects.equals(signature, generateSign(map, key));
    }

    public static MarketResponse pushRequest(MarketItemReqDTO dto) {
        Map<String, Object> map = BeanUtil.beanToMap(dto, true, true);
        String body = HttpRequest.post(URL)
                .header(Header.CONTENT_TYPE, ContentType.JSON.getValue())
                .body(JSONUtil.toJsonStr(map))
                .timeout(5000)
                .execute()
                .body();

        MarketResponse response = JSONUtil.toBean(body, MarketResponse.class);
        response.setItemCode(dto.getCode());
        return response;
    }
}
