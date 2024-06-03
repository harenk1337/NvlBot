import{_ as re,P as ye,F as xe,a as ke,b as Ce,c as Se,D as $e}from"./PageContainer-BNl7fdCx.js";import{i as H,a as ue,_ as ce,b as de}from"./request-gITGYgwF.js";import{d as Re,e as te,a as D,c as ae,_ as Be,B as A}from"./_plugin-vue_export-helper-Di4M-4iM.js";import{B as ze,l as Ve,C as le,E as i,a9 as ie,S as ne,F as R,D as se,g as Fe,G as Ue,H as he,r as m,V as Ne,n as q,I as De,h as r,aa as Pe,ab as Te,L as P,o as fe,c as Ee,w as l,a,f as Oe,b as T,X as Ie,J as Qe,_ as I}from"./index-DwARuaTP.js";import{o as ve,N as X,E as je}from"./EditNoteOutlined-DEdCU_tm.js";import{P as Me}from"./PlusOutlined-Cn6C1N3q.js";import{d as We}from"./Tooltip-TLTbEFla.js";import{e as Ke,p as oe,d as B}from"./Card-CAlJ-zJ5.js";import{c as Le}from"./_common-CtIASumb.js";import{_ as Ae}from"./text-mpzdjKne.js";import"./Ellipsis-Ks8fyx6B.js";const He=e=>{const{primaryColor:v,opacityDisabled:f,borderRadius:c,textColor3:h}=e;return Object.assign(Object.assign({},Le),{iconColor:h,textColor:"white",loadingColor:v,opacityDisabled:f,railColor:"rgba(0, 0, 0, .14)",railColorActive:v,buttonBoxShadow:"0 1px 4px 0 rgba(0, 0, 0, 0.3), inset 0 0 1px 0 rgba(0, 0, 0, 0.05)",buttonColor:"#FFF",railBorderRadiusSmall:c,railBorderRadiusMedium:c,railBorderRadiusLarge:c,buttonBorderRadiusSmall:c,buttonBorderRadiusMedium:c,buttonBorderRadiusLarge:c,boxShadowFocus:`0 0 0 2px ${Ve(v,{alpha:.2})}`})},qe={name:"Switch",common:ze,self:He},Xe=le("switch",`
 height: var(--n-height);
 min-width: var(--n-width);
 vertical-align: middle;
 user-select: none;
 -webkit-user-select: none;
 display: inline-flex;
 outline: none;
 justify-content: center;
 align-items: center;
`,[i("children-placeholder",`
 height: var(--n-rail-height);
 display: flex;
 flex-direction: column;
 overflow: hidden;
 pointer-events: none;
 visibility: hidden;
 `),i("rail-placeholder",`
 display: flex;
 flex-wrap: none;
 `),i("button-placeholder",`
 width: calc(1.75 * var(--n-rail-height));
 height: var(--n-rail-height);
 `),le("base-loading",`
 position: absolute;
 top: 50%;
 left: 50%;
 transform: translateX(-50%) translateY(-50%);
 font-size: calc(var(--n-button-width) - 4px);
 color: var(--n-loading-color);
 transition: color .3s var(--n-bezier);
 `,[ie({left:"50%",top:"50%",originalTransform:"translateX(-50%) translateY(-50%)"})]),i("checked, unchecked",`
 transition: color .3s var(--n-bezier);
 color: var(--n-text-color);
 box-sizing: border-box;
 position: absolute;
 white-space: nowrap;
 top: 0;
 bottom: 0;
 display: flex;
 align-items: center;
 line-height: 1;
 `),i("checked",`
 right: 0;
 padding-right: calc(1.25 * var(--n-rail-height) - var(--n-offset));
 `),i("unchecked",`
 left: 0;
 justify-content: flex-end;
 padding-left: calc(1.25 * var(--n-rail-height) - var(--n-offset));
 `),ne("&:focus",[i("rail",`
 box-shadow: var(--n-box-shadow-focus);
 `)]),R("round",[i("rail","border-radius: calc(var(--n-rail-height) / 2);",[i("button","border-radius: calc(var(--n-button-height) / 2);")])]),se("disabled",[se("icon",[R("rubber-band",[R("pressed",[i("rail",[i("button","max-width: var(--n-button-width-pressed);")])]),i("rail",[ne("&:active",[i("button","max-width: var(--n-button-width-pressed);")])]),R("active",[R("pressed",[i("rail",[i("button","left: calc(100% - var(--n-offset) - var(--n-button-width-pressed));")])]),i("rail",[ne("&:active",[i("button","left: calc(100% - var(--n-offset) - var(--n-button-width-pressed));")])])])])])]),R("active",[i("rail",[i("button","left: calc(100% - var(--n-button-width) - var(--n-offset))")])]),i("rail",`
 overflow: hidden;
 height: var(--n-rail-height);
 min-width: var(--n-rail-width);
 border-radius: var(--n-rail-border-radius);
 cursor: pointer;
 position: relative;
 transition:
 opacity .3s var(--n-bezier),
 background .3s var(--n-bezier),
 box-shadow .3s var(--n-bezier);
 background-color: var(--n-rail-color);
 `,[i("button-icon",`
 color: var(--n-icon-color);
 transition: color .3s var(--n-bezier);
 font-size: calc(var(--n-button-height) - 4px);
 position: absolute;
 left: 0;
 right: 0;
 top: 0;
 bottom: 0;
 display: flex;
 justify-content: center;
 align-items: center;
 line-height: 1;
 `,[ie()]),i("button",`
 align-items: center; 
 top: var(--n-offset);
 left: var(--n-offset);
 height: var(--n-button-height);
 width: var(--n-button-width-pressed);
 max-width: var(--n-button-width);
 border-radius: var(--n-button-border-radius);
 background-color: var(--n-button-color);
 box-shadow: var(--n-button-box-shadow);
 box-sizing: border-box;
 cursor: inherit;
 content: "";
 position: absolute;
 transition:
 background-color .3s var(--n-bezier),
 left .3s var(--n-bezier),
 opacity .3s var(--n-bezier),
 max-width .3s var(--n-bezier),
 box-shadow .3s var(--n-bezier);
 `)]),R("active",[i("rail","background-color: var(--n-rail-color-active);")]),R("loading",[i("rail",`
 cursor: wait;
 `)]),R("disabled",[i("rail",`
 cursor: not-allowed;
 opacity: .5;
 `)])]),Ye=Object.assign(Object.assign({},he.props),{size:{type:String,default:"medium"},value:{type:[String,Number,Boolean],default:void 0},loading:Boolean,defaultValue:{type:[String,Number,Boolean],default:!1},disabled:{type:Boolean,default:void 0},round:{type:Boolean,default:!0},"onUpdate:value":[Function,Array],onUpdateValue:[Function,Array],checkedValue:{type:[String,Number,Boolean],default:!0},uncheckedValue:{type:[String,Number,Boolean],default:!1},railStyle:Function,rubberBand:{type:Boolean,default:!0},onChange:[Function,Array]});let L;const Ge=Fe({name:"Switch",props:Ye,setup(e){L===void 0&&(typeof CSS<"u"?typeof CSS.supports<"u"?L=CSS.supports("width","max(1px)"):L=!1:L=!0);const{mergedClsPrefixRef:v,inlineThemeDisabled:f}=Ue(e),c=he("Switch","-switch",Xe,qe,e,v),h=Re(e),{mergedSizeRef:d,mergedDisabledRef:w}=h,y=m(e.defaultValue),u=Ne(e,"value"),g=Ke(u,y),S=q(()=>g.value===e.checkedValue),x=m(!1),n=m(!1),s=q(()=>{const{railStyle:o}=e;if(o)return o({focused:n.value,checked:S.value})});function p(o){const{"onUpdate:value":N,onChange:z,onUpdateValue:O}=e,{nTriggerFormInput:M,nTriggerFormChange:W}=h;N&&ae(N,o),O&&ae(O,o),z&&ae(z,o),y.value=o,M(),W()}function U(){const{nTriggerFormFocus:o}=h;o()}function Q(){const{nTriggerFormBlur:o}=h;o()}function E(){e.loading||w.value||(g.value!==e.checkedValue?p(e.checkedValue):p(e.uncheckedValue))}function k(){n.value=!0,U()}function j(){n.value=!1,Q(),x.value=!1}function _(o){e.loading||w.value||o.key===" "&&(g.value!==e.checkedValue?p(e.checkedValue):p(e.uncheckedValue),x.value=!1)}function t(o){e.loading||w.value||o.key===" "&&(o.preventDefault(),x.value=!0)}const b=q(()=>{const{value:o}=d,{self:{opacityDisabled:N,railColor:z,railColorActive:O,buttonBoxShadow:M,buttonColor:W,boxShadowFocus:Y,loadingColor:G,textColor:C,iconColor:me,[P("buttonHeight",o)]:V,[P("buttonWidth",o)]:pe,[P("buttonWidthPressed",o)]:be,[P("railHeight",o)]:F,[P("railWidth",o)]:K,[P("railBorderRadius",o)]:ge,[P("buttonBorderRadius",o)]:_e},common:{cubicBezierEaseInOut:we}}=c.value;let J,Z,ee;return L?(J=`calc((${F} - ${V}) / 2)`,Z=`max(${F}, ${V})`,ee=`max(${K}, calc(${K} + ${V} - ${F}))`):(J=oe((B(F)-B(V))/2),Z=oe(Math.max(B(F),B(V))),ee=B(F)>B(V)?K:oe(B(K)+B(V)-B(F))),{"--n-bezier":we,"--n-button-border-radius":_e,"--n-button-box-shadow":M,"--n-button-color":W,"--n-button-width":pe,"--n-button-width-pressed":be,"--n-button-height":V,"--n-height":Z,"--n-offset":J,"--n-opacity-disabled":N,"--n-rail-border-radius":ge,"--n-rail-color":z,"--n-rail-color-active":O,"--n-rail-height":F,"--n-rail-width":K,"--n-width":ee,"--n-box-shadow-focus":Y,"--n-loading-color":G,"--n-text-color":C,"--n-icon-color":me}}),$=f?De("switch",q(()=>d.value[0]),b,e):void 0;return{handleClick:E,handleBlur:j,handleFocus:k,handleKeyup:_,handleKeydown:t,mergedRailStyle:s,pressed:x,mergedClsPrefix:v,mergedValue:g,checked:S,mergedDisabled:w,cssVars:f?void 0:b,themeClass:$==null?void 0:$.themeClass,onRender:$==null?void 0:$.onRender}},render(){const{mergedClsPrefix:e,mergedDisabled:v,checked:f,mergedRailStyle:c,onRender:h,$slots:d}=this;h==null||h();const{checked:w,unchecked:y,icon:u,"checked-icon":g,"unchecked-icon":S}=d,x=!(te(u)&&te(g)&&te(S));return r("div",{role:"switch","aria-checked":f,class:[`${e}-switch`,this.themeClass,x&&`${e}-switch--icon`,f&&`${e}-switch--active`,v&&`${e}-switch--disabled`,this.round&&`${e}-switch--round`,this.loading&&`${e}-switch--loading`,this.pressed&&`${e}-switch--pressed`,this.rubberBand&&`${e}-switch--rubber-band`],tabindex:this.mergedDisabled?void 0:0,style:this.cssVars,onClick:this.handleClick,onFocus:this.handleFocus,onBlur:this.handleBlur,onKeyup:this.handleKeyup,onKeydown:this.handleKeydown},r("div",{class:`${e}-switch__rail`,"aria-hidden":"true",style:c},D(w,n=>D(y,s=>n||s?r("div",{"aria-hidden":!0,class:`${e}-switch__children-placeholder`},r("div",{class:`${e}-switch__rail-placeholder`},r("div",{class:`${e}-switch__button-placeholder`}),n),r("div",{class:`${e}-switch__rail-placeholder`},r("div",{class:`${e}-switch__button-placeholder`}),s)):null)),r("div",{class:`${e}-switch__button`},D(u,n=>D(g,s=>D(S,p=>r(Pe,null,{default:()=>this.loading?r(Te,{key:"loading",clsPrefix:e,strokeWidth:20}):this.checked&&(s||n)?r("div",{class:`${e}-switch__button-icon`,key:s?"checked-icon":"icon"},s||n):!this.checked&&(p||n)?r("div",{class:`${e}-switch__button-icon`,key:p?"unchecked-icon":"icon"},p||n):null})))),D(w,n=>n&&r("div",{key:"checked",class:`${e}-switch__checked`},n)),D(y,n=>n&&r("div",{key:"unchecked",class:`${e}-switch__unchecked`},n)))))}}),Je=e=>H.post("/user/list",e),Ze=e=>H.post("/user",e),et=e=>H.put(`/user/disable/${e}`),tt=e=>H.put(`/user/enable/${e}`),at=e=>H.delete(`/user/${e}`),nt={style:{display:"flex","justify-content":"flex-end"}},ot={__name:"UserEdit",emits:["submit"],setup(e,{expose:v,emit:f}){const c=m(!1),h=m(""),d=m({id:0,name:"",account:"",role:0,status:0}),w={name:[{required:!0,message:"请输入用户名",trigger:"blur"}],account:[{required:!0,message:"请输入账号",trigger:"blur"},{pattern:/^\d{5,11}$/,message:"QQ 应为长度为 5-11 的数字",trigger:"blur"}]},y=n=>!n||/^\d+$/.test(n),u=[{label:"超管",value:1},{label:"用户",value:0}];v({open:n=>{c.value=!0,d.value={...n}}});const S=f,x=async()=>{await h.value.validate(),await Ze(d.value).then(()=>{const n=d.value.id?"编辑":"新增";window.$message.success(`成功${n}用户 ${d.value.name} ！`),S("submit")}),c.value=!1};return(n,s)=>{const p=ue,U=ce,Q=re,E=de,k=A,j=ve;return fe(),Ee(j,{show:c.value,"onUpdate:show":s[4]||(s[4]=_=>c.value=_),preset:"card",title:d.value.id?"编辑用户":"新增用户",style:{width:"450px"},size:"medium",segmented:{content:"soft"}},{default:l(()=>[a(E,{size:"large",ref_key:"formRef",ref:h,model:d.value,rules:w},{default:l(()=>[a(U,{label:"用户名",path:"name"},{default:l(()=>[a(p,{value:d.value.name,"onUpdate:value":s[0]||(s[0]=_=>d.value.name=_),clearable:""},null,8,["value"])]),_:1}),a(U,{label:"用户 QQ",path:"account"},{default:l(()=>[a(p,{value:d.value.account,"onUpdate:value":s[1]||(s[1]=_=>d.value.account=_),"allow-input":y,clearable:""},null,8,["value"])]),_:1}),a(U,{label:"用户角色"},{default:l(()=>[a(Q,{value:d.value.role,"onUpdate:value":s[2]||(s[2]=_=>d.value.role=_),options:u,clearable:""},null,8,["value"])]),_:1})]),_:1},8,["model"])]),footer:l(()=>[Oe("div",nt,[a(k,{ghost:"",onClick:s[3]||(s[3]=_=>c.value=!1),size:"medium"},{default:l(()=>[T("取消")]),_:1}),a(k,{type:"primary",size:"medium",style:{"margin-left":"10px"},onClick:x},{default:l(()=>[T("确定")]),_:1})])]),_:1},8,["show","title"])}}},lt=Be(ot,[["__scopeId","data-v-a10440fc"]]),bt={__name:"index",setup(e){const v=m(),f=m({}),c=m(!1),h=m(),d=()=>{var t;(t=h.value)==null||t.downloadCsv({fileName:"Users"})},w=[{title:"用户名",key:"name"},{title:"用户QQ",key:"account"},{title:"角色",key:"role",render(t){return r(We,{type:t.role===1?"warning":"info"},{default:()=>t.role===1?"超管":"用户"})}},{title:"状态",key:"enable",render:t=>r(Ge,{size:"medium",value:t.status===1,onUpdateValue:()=>x(t)},{checked:()=>"启用",unchecked:()=>"禁用"})},{title:"操作",key:"actions",fixed:"right",align:"right",width:320,render(t){return[r(A,{size:"medium",style:{marginRight:"10px"},type:"primary",onClick:()=>U(t)},{default:()=>"编辑",icon:()=>r(X,null,{default:()=>r(je)})}),r(A,{size:"medium",type:"error",onClick:()=>j(t)},{default:()=>"删除",icon:()=>r(X,null,{default:()=>r($e)})})]}}],y=m([]),u=m({page:1,pageSize:10,name:"",account:"",role:""}),g=async()=>{c.value=!0,await Je(u.value).then(({data:t})=>{y.value=t.records,f.value.page=t.page,f.value.pageSize=t.pageSize,f.value.itemCount=t.itemCount,f.value.pageCount=t.pageCount}).finally(()=>c.value=!1)};g();const S=async t=>{u.value.page=t,await g()},x=async t=>{t.status===1?await et(t.id).then(()=>{t.status=0,window.$message.success("用户已禁用！")}):await tt(t.id).then(()=>{t.status=1,window.$message.success("用户已启用！")})},n=async()=>{u.value.page=1,await g()},s=()=>{u.value.page=1,u.value.name="",u.value.account="",u.value.role="",n()},p=()=>{v.value.open({})},U=t=>{v.value.open(t)},Q=async()=>{await s()},E=m(0),k=m(!1),j=t=>{k.value=!0,E.value=t.id},_=async()=>{k.value=!1,await at(E.value).then(async()=>{window.$message.success("成功删除用户！"),await s()})};return(t,b)=>{const $=ke,o=ue,N=Ce,z=ce,O=Ae,M=re,W=de,Y=Se,G=ve;return fe(),Ie(Qe,null,[a(ye,{titleText:"用户管理","onReset:btnClick":s,"onSearch:btnClick":n},{extra:l(()=>[a(I(A),{ghost:"",onClick:d},{icon:l(()=>[a(I(X),null,{default:l(()=>[a(I(xe))]),_:1})]),default:l(()=>[T(" 导出 ")]),_:1}),a(I(A),{type:"primary",onClick:p,style:{"margin-left":"10px"}},{icon:l(()=>[a(I(X),null,{default:l(()=>[a(I(Me))]),_:1})]),default:l(()=>[T(" 新增 ")]),_:1})]),"search-form":l(()=>[a(W,{inline:"",model:u.value},{default:l(()=>[a(z,null,{default:l(()=>[a(N,null,{default:l(()=>[a($,null,{default:l(()=>[T("用户名")]),_:1}),a(o,{value:u.value.name,"onUpdate:value":b[0]||(b[0]=C=>u.value.name=C),clearable:""},null,8,["value"])]),_:1})]),_:1}),a(z,null,{default:l(()=>[a(N,null,{default:l(()=>[a($,null,{default:l(()=>[T("用户QQ")]),_:1}),a(o,{value:u.value.account,"onUpdate:value":b[1]||(b[1]=C=>u.value.account=C),clearable:""},null,8,["value"])]),_:1})]),_:1}),a(z,null,{default:l(()=>[a(O,null,{default:l(()=>[T("角色: ")]),_:1}),a(M,{value:u.value.role,"onUpdate:value":b[2]||(b[2]=C=>u.value.role=C),style:{width:"120px","margin-left":"5px"},clearable:"","label-field":"label",placeholder:"请选择角色",options:[{label:"超管",value:1},{label:"用户",value:0}]},null,8,["value"])]),_:1})]),_:1},8,["model"])]),"data-show":l(()=>[a(Y,{ref_key:"tableRef",ref:h,striped:"",remote:"",loading:c.value,style:{"margin-top":"20px"},columns:w,data:y.value,pagination:f.value,"onUpdate:page":S},null,8,["loading","data","pagination"])]),_:1}),a(lt,{ref_key:"modalRef",ref:v,onSubmit:Q},null,512),a(G,{show:k.value,"onUpdate:show":b[3]||(b[3]=C=>k.value=C),preset:"dialog",title:"确认",content:"你确认要删除该用户吗?","positive-text":"确认","negative-text":"取消",onNegativeClick:b[4]||(b[4]=C=>k.value=!1),onPositiveClick:_},null,8,["show"])],64)}}};export{bt as default};
