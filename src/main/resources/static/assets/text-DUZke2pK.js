import{B as y,C as B,F as g,g as S,G as z,H as b,n as f,I as T,h as C,L as W}from"./index-CxeEYQK2.js";import{u as P}from"./Tooltip-ClqWcAWi.js";const F={headerFontSize1:"30px",headerFontSize2:"22px",headerFontSize3:"18px",headerFontSize4:"16px",headerFontSize5:"16px",headerFontSize6:"16px",headerMargin1:"28px 0 20px 0",headerMargin2:"28px 0 20px 0",headerMargin3:"28px 0 20px 0",headerMargin4:"28px 0 18px 0",headerMargin5:"28px 0 18px 0",headerMargin6:"28px 0 18px 0",headerPrefixWidth1:"16px",headerPrefixWidth2:"16px",headerPrefixWidth3:"12px",headerPrefixWidth4:"12px",headerPrefixWidth5:"12px",headerPrefixWidth6:"12px",headerBarWidth1:"4px",headerBarWidth2:"4px",headerBarWidth3:"3px",headerBarWidth4:"3px",headerBarWidth5:"3px",headerBarWidth6:"3px",pMargin:"16px 0 16px 0",liMargin:".25em 0 0 0",olPadding:"0 0 0 2em",ulPadding:"0 0 0 2em"},M=r=>{const{primaryColor:t,textColor2:o,borderColor:i,lineHeight:n,fontSize:e,borderRadiusSmall:l,dividerColor:d,fontWeightStrong:u,textColor1:a,textColor3:s,infoColor:c,warningColor:h,errorColor:x,successColor:p,codeColor:m}=r;return Object.assign(Object.assign({},F),{aTextColor:t,blockquoteTextColor:o,blockquotePrefixColor:i,blockquoteLineHeight:n,blockquoteFontSize:e,codeBorderRadius:l,liTextColor:o,liLineHeight:n,liFontSize:e,hrColor:d,headerFontWeight:u,headerTextColor:a,pTextColor:o,pTextColor1Depth:a,pTextColor2Depth:o,pTextColor3Depth:s,pLineHeight:n,pFontSize:e,headerBarColor:t,headerBarColorPrimary:t,headerBarColorInfo:c,headerBarColorError:x,headerBarColorWarning:h,headerBarColorSuccess:p,textColor:o,textColor1Depth:a,textColor2Depth:o,textColor3Depth:s,textColorPrimary:t,textColorInfo:c,textColorSuccess:p,textColorWarning:h,textColorError:x,codeTextColor:o,codeColor:m,codeBorder:"1px solid #0000"})},$={name:"Typography",common:y,self:M},D=B("text",`
 transition: color .3s var(--n-bezier);
 color: var(--n-text-color);
`,[g("strong",`
 font-weight: var(--n-font-weight-strong);
 `),g("italic",{fontStyle:"italic"}),g("underline",{textDecoration:"underline"}),g("code",`
 line-height: 1.4;
 display: inline-block;
 font-family: var(--n-font-famliy-mono);
 transition: 
 color .3s var(--n-bezier),
 border-color .3s var(--n-bezier),
 background-color .3s var(--n-bezier);
 box-sizing: border-box;
 padding: .05em .35em 0 .35em;
 border-radius: var(--n-code-border-radius);
 font-size: .9em;
 color: var(--n-code-text-color);
 background-color: var(--n-code-color);
 border: var(--n-code-border);
 `)]),R=Object.assign(Object.assign({},b.props),{code:Boolean,type:{type:String,default:"default"},delete:Boolean,strong:Boolean,italic:Boolean,underline:Boolean,depth:[String,Number],tag:String,as:{type:String,validator:()=>!0,default:void 0}}),H=S({name:"Text",props:R,setup(r){const{mergedClsPrefixRef:t,inlineThemeDisabled:o}=z(r),i=b("Typography","-text",D,$,r,t),n=f(()=>{const{depth:l,type:d}=r,u=d==="default"?l===void 0?"textColor":`textColor${l}Depth`:W("textColor",d),{common:{fontWeightStrong:a,fontFamilyMono:s,cubicBezierEaseInOut:c},self:{codeTextColor:h,codeBorderRadius:x,codeColor:p,codeBorder:m,[u]:v}}=i.value;return{"--n-bezier":c,"--n-text-color":v,"--n-font-weight-strong":a,"--n-font-famliy-mono":s,"--n-code-border-radius":x,"--n-code-text-color":h,"--n-code-color":p,"--n-code-border":m}}),e=o?T("text",f(()=>`${r.type[0]}${r.depth||""}`),n,r):void 0;return{mergedClsPrefix:t,compitableTag:P(r,["as","tag"]),cssVars:o?void 0:n,themeClass:e==null?void 0:e.themeClass,onRender:e==null?void 0:e.onRender}},render(){var r,t,o;const{mergedClsPrefix:i}=this;(r=this.onRender)===null||r===void 0||r.call(this);const n=[`${i}-text`,this.themeClass,{[`${i}-text--code`]:this.code,[`${i}-text--delete`]:this.delete,[`${i}-text--strong`]:this.strong,[`${i}-text--italic`]:this.italic,[`${i}-text--underline`]:this.underline}],e=(o=(t=this.$slots).default)===null||o===void 0?void 0:o.call(t);return this.code?C("code",{class:n,style:this.cssVars},this.delete?C("del",null,e):e):this.delete?C("del",{class:n,style:this.cssVars},e):C(this.compitableTag||"span",{class:n,style:this.cssVars},e)}});export{H as _,M as s};
