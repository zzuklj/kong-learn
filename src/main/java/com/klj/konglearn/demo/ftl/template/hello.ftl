
<#--<#if jpush??>-->
<#--jpush:-->
<#--<#if jpush.common??>-->
<#--  common:-->
<#--    appKey: ${jpush.common['appKey']}-->
<#--    masterSecret: ${jpush.common['masterSecret']}-->
<#--    apnsProduction: ${jpush.common['apnsProduction']?string('true', 'false')}-->
<#--</#if>-->
<#--<#if jpush.xm??>-->
<#--  xm:-->
<#--    appKey: ${jpush.xm['appKey']}-->
<#--    masterSecret: ${jpush.xm['masterSecret']}-->
<#--    apnsProduction: ${jpush.xm['apnsProduction']?string('true', 'false')}-->
<#--</#if>-->
<#--</#if>-->

<#if jpush??>
jpush:
    appKey: ${jpush['appKey']}
    masterSecret: ${jpush['masterSecret']}
    apnsProduction: ${jpush['apnsProduction']?string('true', 'false')}
</#if>

<#if sms?? && sms.tencent?? >
sms:
  tencent:
    appId: ${sms.tencent['appId']}
    appKey: ${sms.tencent['appKey']}
    nationCode: ${sms.tencent['nationCode']}
</#if>

