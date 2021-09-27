
<#if jpush??>
jpush:
<#if jpush.common??>
  common:
    appKey: ${jpush.common['appKey']}
    masterSecret: ${jpush.common['masterSecret']}
    apnsProduction: ${jpush.common['apnsProduction']?string('true', 'false')}
</#if>
<#if jpush.xm??>
  xm:
    appKey: ${jpush.xm['appKey']}
    masterSecret: ${jpush.xm['masterSecret']}
    apnsProduction: ${jpush.xm['apnsProduction']?string('true', 'false')}
</#if>
</#if>

<#if sms.tencent?? >
sms:
  tencent:
    appId: ${sms.tencent['appId']}
    appKey: ${sms.tencent['appKey']}
    nationCode: ${sms.tencent['nationCode']}
</#if>

