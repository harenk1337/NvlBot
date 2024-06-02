import{_ as ie,P as ye,a as xe,b as ke,c as Ce,D as Se}from"./PageContainer-CRy4s3FT.js";import{i as K,a as se,_ as re,b as ue}from"./request-Bc3qVART.js";import{d as $e,e as G,a as F,c as J,_ as Re,B as H}from"./_plugin-vue_export-helper-D4-TxSuL.js";import{B as Be,l as ze,C as ne,E as l,a9 as oe,S as Z,F as S,D as le,g as Ve,G as Fe,H as ce,r as b,V as Ue,n as A,I as Ne,h as r,aa as De,ab as Pe,L as U,o as de,c as Te,w as s,a as n,f as Ee,b as E,X as Oe,J as Ie,_ as ee}from"./index-D4Z3ZAA6.js";import{o as he,N as te,E as Qe}from"./EditNoteOutlined-DqlHLWxO.js";import{P as je}from"./PlusOutlined-BnCeVpoc.js";import{d as Me}from"./Tooltip-DDFAPL4M.js";import{e as We,p as ae,d as $}from"./Card-8ypUEVBx.js";import{c as Ke}from"./_common-CtIASumb.js";import{_ as Le}from"./text-DlP9GNh1.js";import"./Ellipsis-hqL9jw98.js";const Ae=e=>{const{primaryColor:m,opacityDisabled:v,borderRadius:h,textColor3:f}=e;return Object.assign(Object.assign({},Ke),{iconColor:f,textColor:"white",loadingColor:m,opacityDisabled:v,railColor:"rgba(0, 0, 0, .14)",railColorActive:m,buttonBoxShadow:"0 1px 4px 0 rgba(0, 0, 0, 0.3), inset 0 0 1px 0 rgba(0, 0, 0, 0.05)",buttonColor:"#FFF",railBorderRadiusSmall:h,railBorderRadiusMedium:h,railBorderRadiusLarge:h,buttonBorderRadiusSmall:h,buttonBorderRadiusMedium:h,buttonBorderRadiusLarge:h,boxShadowFocus:`0 0 0 2px ${ze(m,{alpha:.2})}`})},He={name:"Switch",common:Be,self:Ae},qe=ne("switch",`
 height: var(--n-height);
 min-width: var(--n-width);
 vertical-align: middle;
 user-select: none;
 -webkit-user-select: none;
 display: inline-flex;
 outline: none;
 justify-content: center;
 align-items: center;
`,[l("children-placeholder",`
 height: var(--n-rail-height);
 display: flex;
 flex-direction: column;
 overflow: hidden;
 pointer-events: none;
 visibility: hidden;
 `),l("rail-placeholder",`
 display: flex;
 flex-wrap: none;
 `),l("button-placeholder",`
 width: calc(1.75 * var(--n-rail-height));
 height: var(--n-rail-height);
 `),ne("base-loading",`
 position: absolute;
 top: 50%;
 left: 50%;
 transform: translateX(-50%) translateY(-50%);
 font-size: calc(var(--n-button-width) - 4px);
 color: var(--n-loading-color);
 transition: color .3s var(--n-bezier);
 `,[oe({left:"50%",top:"50%",originalTransform:"translateX(-50%) translateY(-50%)"})]),l("checked, unchecked",`
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
 `),l("checked",`
 right: 0;
 padding-right: calc(1.25 * var(--n-rail-height) - var(--n-offset));
 `),l("unchecked",`
 left: 0;
 justify-content: flex-end;
 padding-left: calc(1.25 * var(--n-rail-height) - var(--n-offset));
 `),Z("&:focus",[l("rail",`
 box-shadow: var(--n-box-shadow-focus);
 `)]),S("round",[l("rail","border-radius: calc(var(--n-rail-height) / 2);",[l("button","border-radius: calc(var(--n-button-height) / 2);")])]),le("disabled",[le("icon",[S("rubber-band",[S("pressed",[l("rail",[l("button","max-width: var(--n-button-width-pressed);")])]),l("rail",[Z("&:active",[l("button","max-width: var(--n-button-width-pressed);")])]),S("active",[S("pressed",[l("rail",[l("button","left: calc(100% - var(--n-offset) - var(--n-button-width-pressed));")])]),l("rail",[Z("&:active",[l("button","left: calc(100% - var(--n-offset) - var(--n-button-width-pressed));")])])])])])]),S("active",[l("rail",[l("button","left: calc(100% - var(--n-button-width) - var(--n-offset))")])]),l("rail",`
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
 `,[l("button-icon",`
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
 `,[oe()]),l("button",`
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
 `)]),S("active",[l("rail","background-color: var(--n-rail-color-active);")]),S("loading",[l("rail",`
 cursor: wait;
 `)]),S("disabled",[l("rail",`
 cursor: not-allowed;
 opacity: .5;
 `)])]),Xe=Object.assign(Object.assign({},ce.props),{size:{type:String,default:"medium"},value:{type:[String,Number,Boolean],default:void 0},loading:Boolean,defaultValue:{type:[String,Number,Boolean],default:!1},disabled:{type:Boolean,default:void 0},round:{type:Boolean,default:!0},"onUpdate:value":[Function,Array],onUpdateValue:[Function,Array],checkedValue:{type:[String,Number,Boolean],default:!0},uncheckedValue:{type:[String,Number,Boolean],default:!1},railStyle:Function,rubberBand:{type:Boolean,default:!0},onChange:[Function,Array]});let W;const Ye=Ve({name:"Switch",props:Xe,setup(e){W===void 0&&(typeof CSS<"u"?typeof CSS.supports<"u"?W=CSS.supports("width","max(1px)"):W=!1:W=!0);const{mergedClsPrefixRef:m,inlineThemeDisabled:v}=Fe(e),h=ce("Switch","-switch",qe,He,e,m),f=$e(e),{mergedSizeRef:u,mergedDisabledRef:i}=f,_=b(e.defaultValue),R=Ue(e,"value"),w=We(R,_),y=A(()=>w.value===e.checkedValue),g=b(!1),o=b(!1),c=A(()=>{const{railStyle:a}=e;if(a)return a({focused:o.value,checked:y.value})});function p(a){const{"onUpdate:value":D,onChange:P,onUpdateValue:T}=e,{nTriggerFormInput:Q,nTriggerFormChange:j}=f;D&&J(D,a),T&&J(T,a),P&&J(P,a),_.value=a,Q(),j()}function B(){const{nTriggerFormFocus:a}=f;a()}function k(){const{nTriggerFormBlur:a}=f;a()}function O(){e.loading||i.value||(w.value!==e.checkedValue?p(e.checkedValue):p(e.uncheckedValue))}function N(){o.value=!0,B()}function t(){o.value=!1,k(),g.value=!1}function d(a){e.loading||i.value||a.key===" "&&(w.value!==e.checkedValue?p(e.checkedValue):p(e.uncheckedValue),g.value=!1)}function L(a){e.loading||i.value||a.key===" "&&(a.preventDefault(),g.value=!0)}const I=A(()=>{const{value:a}=u,{self:{opacityDisabled:D,railColor:P,railColorActive:T,buttonBoxShadow:Q,buttonColor:j,boxShadowFocus:x,loadingColor:ve,textColor:fe,iconColor:me,[U("buttonHeight",a)]:z,[U("buttonWidth",a)]:pe,[U("buttonWidthPressed",a)]:be,[U("railHeight",a)]:V,[U("railWidth",a)]:M,[U("railBorderRadius",a)]:ge,[U("buttonBorderRadius",a)]:_e},common:{cubicBezierEaseInOut:we}}=h.value;let q,X,Y;return W?(q=`calc((${V} - ${z}) / 2)`,X=`max(${V}, ${z})`,Y=`max(${M}, calc(${M} + ${z} - ${V}))`):(q=ae(($(V)-$(z))/2),X=ae(Math.max($(V),$(z))),Y=$(V)>$(z)?M:ae($(M)+$(z)-$(V))),{"--n-bezier":we,"--n-button-border-radius":_e,"--n-button-box-shadow":Q,"--n-button-color":j,"--n-button-width":pe,"--n-button-width-pressed":be,"--n-button-height":z,"--n-height":X,"--n-offset":q,"--n-opacity-disabled":D,"--n-rail-border-radius":ge,"--n-rail-color":P,"--n-rail-color-active":T,"--n-rail-height":V,"--n-rail-width":M,"--n-width":Y,"--n-box-shadow-focus":x,"--n-loading-color":ve,"--n-text-color":fe,"--n-icon-color":me}}),C=v?Ne("switch",A(()=>u.value[0]),I,e):void 0;return{handleClick:O,handleBlur:t,handleFocus:N,handleKeyup:d,handleKeydown:L,mergedRailStyle:c,pressed:g,mergedClsPrefix:m,mergedValue:w,checked:y,mergedDisabled:i,cssVars:v?void 0:I,themeClass:C==null?void 0:C.themeClass,onRender:C==null?void 0:C.onRender}},render(){const{mergedClsPrefix:e,mergedDisabled:m,checked:v,mergedRailStyle:h,onRender:f,$slots:u}=this;f==null||f();const{checked:i,unchecked:_,icon:R,"checked-icon":w,"unchecked-icon":y}=u,g=!(G(R)&&G(w)&&G(y));return r("div",{role:"switch","aria-checked":v,class:[`${e}-switch`,this.themeClass,g&&`${e}-switch--icon`,v&&`${e}-switch--active`,m&&`${e}-switch--disabled`,this.round&&`${e}-switch--round`,this.loading&&`${e}-switch--loading`,this.pressed&&`${e}-switch--pressed`,this.rubberBand&&`${e}-switch--rubber-band`],tabindex:this.mergedDisabled?void 0:0,style:this.cssVars,onClick:this.handleClick,onFocus:this.handleFocus,onBlur:this.handleBlur,onKeyup:this.handleKeyup,onKeydown:this.handleKeydown},r("div",{class:`${e}-switch__rail`,"aria-hidden":"true",style:h},F(i,o=>F(_,c=>o||c?r("div",{"aria-hidden":!0,class:`${e}-switch__children-placeholder`},r("div",{class:`${e}-switch__rail-placeholder`},r("div",{class:`${e}-switch__button-placeholder`}),o),r("div",{class:`${e}-switch__rail-placeholder`},r("div",{class:`${e}-switch__button-placeholder`}),c)):null)),r("div",{class:`${e}-switch__button`},F(R,o=>F(w,c=>F(y,p=>r(De,null,{default:()=>this.loading?r(Pe,{key:"loading",clsPrefix:e,strokeWidth:20}):this.checked&&(c||o)?r("div",{class:`${e}-switch__button-icon`,key:c?"checked-icon":"icon"},c||o):!this.checked&&(p||o)?r("div",{class:`${e}-switch__button-icon`,key:p?"unchecked-icon":"icon"},p||o):null})))),F(i,o=>o&&r("div",{key:"checked",class:`${e}-switch__checked`},o)),F(_,o=>o&&r("div",{key:"unchecked",class:`${e}-switch__unchecked`},o)))))}}),Ge=e=>K.post("/user/list",e),Je=e=>K.post("/user",e),Ze=e=>K.put(`/user/disable/${e}`),et=e=>K.put(`/user/enable/${e}`),tt=e=>K.delete(`/user/${e}`),at={style:{display:"flex","justify-content":"flex-end"}},nt={__name:"UserEdit",emits:["submit"],setup(e,{expose:m,emit:v}){const h=b(!1),f=b(""),u=b({id:0,name:"",account:"",role:0,status:0}),i={name:[{required:!0,message:"请输入用户名",trigger:"blur"}],account:[{required:!0,message:"请输入账号",trigger:"blur"},{pattern:/^\d{5,11}$/,message:"QQ 应为长度为 5-11 的数字",trigger:"blur"}]},_=o=>!o||/^\d+$/.test(o),R=[{label:"超管",value:1},{label:"用户",value:0}];m({open:o=>{h.value=!0,u.value={...o}}});const y=v,g=async()=>{await f.value.validate(),await Je(u.value).then(()=>{const o=u.value.id?"编辑":"新增";window.$message.success(`成功${o}用户 ${u.value.name} ！`),y("submit")}),h.value=!1};return(o,c)=>{const p=se,B=re,k=ie,O=ue,N=H,t=he;return de(),Te(t,{show:h.value,"onUpdate:show":c[4]||(c[4]=d=>h.value=d),preset:"card",title:u.value.id?"编辑用户":"新增用户",style:{width:"450px"},size:"medium",segmented:{content:"soft"}},{default:s(()=>[n(O,{size:"large",ref_key:"formRef",ref:f,model:u.value,rules:i},{default:s(()=>[n(B,{label:"用户名",path:"name"},{default:s(()=>[n(p,{value:u.value.name,"onUpdate:value":c[0]||(c[0]=d=>u.value.name=d),clearable:""},null,8,["value"])]),_:1}),n(B,{label:"用户 QQ",path:"account"},{default:s(()=>[n(p,{value:u.value.account,"onUpdate:value":c[1]||(c[1]=d=>u.value.account=d),"allow-input":_,clearable:""},null,8,["value"])]),_:1}),n(B,{label:"用户角色"},{default:s(()=>[n(k,{value:u.value.role,"onUpdate:value":c[2]||(c[2]=d=>u.value.role=d),options:R,clearable:""},null,8,["value"])]),_:1})]),_:1},8,["model"])]),footer:s(()=>[Ee("div",at,[n(N,{ghost:"",onClick:c[3]||(c[3]=d=>h.value=!1),size:"medium"},{default:s(()=>[E("取消")]),_:1}),n(N,{type:"primary",size:"medium",style:{"margin-left":"10px"},onClick:g},{default:s(()=>[E("确定")]),_:1})])]),_:1},8,["show","title"])}}},ot=Re(nt,[["__scopeId","data-v-a10440fc"]]),pt={__name:"index",setup(e){const m=b(),v=b({}),h=b(!1),f=[{title:"用户名",key:"name"},{title:"用户QQ",key:"account"},{title:"角色",key:"role",render(t){return r(Me,{type:t.role===1?"warning":"info"},{default:()=>t.role===1?"超管":"用户"})}},{title:"状态",key:"enable",render:t=>r(Ye,{size:"medium",value:t.status===1,onUpdateValue:()=>w(t)},{checked:()=>"启用",unchecked:()=>"禁用"})},{title:"操作",key:"actions",fixed:"right",align:"right",width:320,render(t){return[r(H,{size:"medium",style:{marginRight:"10px"},type:"primary",onClick:()=>c(t)},{default:()=>"编辑",icon:()=>r(te,null,{default:()=>r(Qe)})}),r(H,{size:"medium",type:"error",onClick:()=>O(t)},{default:()=>"删除",icon:()=>r(te,null,{default:()=>r(Se)})})]}}],u=b([]),i=b({page:1,pageSize:10,name:"",account:"",role:""}),_=async()=>{h.value=!0,await Ge(i.value).then(({data:t})=>{u.value=t.records,v.value.page=t.page,v.value.pageSize=t.pageSize,v.value.itemCount=t.itemCount,v.value.pageCount=t.pageCount}).finally(()=>h.value=!1)};_();const R=async t=>{i.value.page=t,await _()},w=async t=>{t.status===1?await Ze(t.id).then(()=>{t.status=0,window.$message.success("用户已禁用！")}):await et(t.id).then(()=>{t.status=1,window.$message.success("用户已启用！")})},y=async()=>{i.value.page=1,await _()},g=()=>{i.value.page=1,i.value.name="",i.value.account="",i.value.role="",y()},o=()=>{m.value.open({})},c=t=>{m.value.open(t)},p=async()=>{await g()},B=b(0),k=b(!1),O=t=>{k.value=!0,B.value=t.id},N=async()=>{k.value=!1,await tt(B.value).then(async()=>{window.$message.success("成功删除用户！"),await g()})};return(t,d)=>{const L=xe,I=se,C=ke,a=re,D=Le,P=ie,T=ue,Q=Ce,j=he;return de(),Oe(Ie,null,[n(ye,{titleText:"用户管理","onReset:btnClick":g,"onSearch:btnClick":y},{extra:s(()=>[n(ee(H),{type:"primary",onClick:o},{icon:s(()=>[n(ee(te),null,{default:s(()=>[n(ee(je))]),_:1})]),default:s(()=>[E(" 新增 ")]),_:1})]),"search-form":s(()=>[n(T,{inline:"",model:i.value},{default:s(()=>[n(a,null,{default:s(()=>[n(C,null,{default:s(()=>[n(L,null,{default:s(()=>[E("用户名")]),_:1}),n(I,{value:i.value.name,"onUpdate:value":d[0]||(d[0]=x=>i.value.name=x),clearable:""},null,8,["value"])]),_:1})]),_:1}),n(a,null,{default:s(()=>[n(C,null,{default:s(()=>[n(L,null,{default:s(()=>[E("用户QQ")]),_:1}),n(I,{value:i.value.account,"onUpdate:value":d[1]||(d[1]=x=>i.value.account=x),clearable:""},null,8,["value"])]),_:1})]),_:1}),n(a,null,{default:s(()=>[n(D,null,{default:s(()=>[E("角色: ")]),_:1}),n(P,{value:i.value.role,"onUpdate:value":d[2]||(d[2]=x=>i.value.role=x),style:{width:"120px","margin-left":"5px"},clearable:"","label-field":"label",placeholder:"请选择角色",options:[{label:"超管",value:1},{label:"用户",value:0}]},null,8,["value"])]),_:1})]),_:1},8,["model"])]),"data-show":s(()=>[n(Q,{striped:"",remote:"",loading:h.value,style:{"margin-top":"20px"},columns:f,data:u.value,pagination:v.value,"onUpdate:page":R},null,8,["loading","data","pagination"])]),_:1}),n(ot,{ref_key:"modalRef",ref:m,onSubmit:p},null,512),n(j,{show:k.value,"onUpdate:show":d[3]||(d[3]=x=>k.value=x),preset:"dialog",title:"确认",content:"你确认要删除该用户吗?","positive-text":"确认","negative-text":"取消",onNegativeClick:d[4]||(d[4]=x=>k.value=!1),onPositiveClick:N},null,8,["show"])],64)}}};export{pt as default};
