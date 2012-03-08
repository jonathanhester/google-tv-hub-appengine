// Automatically Generated -- DO NOT EDIT
// com.jonathanhester.gtvhub.client.MyRequestFactory
package com.jonathanhester.gtvhub.client;
import java.util.Arrays;
import com.google.web.bindery.requestfactory.vm.impl.OperationData;
import com.google.web.bindery.requestfactory.vm.impl.OperationKey;
public final class MyRequestFactoryDeobfuscatorBuilder extends com.google.web.bindery.requestfactory.vm.impl.Deobfuscator.Builder {
{
withOperation(new OperationKey("mjqEJ87WIeg8I__AooIbgW$HgWU="),
  new OperationData.Builder()
  .withClientMethodDescriptor("(Lcom/jonathanhester/gtvhub/shared/UserDeviceProxy;)Lcom/google/web/bindery/requestfactory/shared/Request;")
  .withDomainMethodDescriptor("(Lcom/jonathanhester/gtvhub/server/UserDevice;)V")
  .withMethodName("deleteUserDevice")
  .withRequestContext("com.jonathanhester.gtvhub.shared.GtvhubRequest")
  .build());
withOperation(new OperationKey("tFk54CFepzXoYcKHmtqafGYyV00="),
  new OperationData.Builder()
  .withClientMethodDescriptor("()Lcom/google/web/bindery/requestfactory/shared/Request;")
  .withDomainMethodDescriptor("()Ljava/util/List;")
  .withMethodName("queryUserDevices")
  .withRequestContext("com.jonathanhester.gtvhub.shared.GtvhubRequest")
  .build());
withOperation(new OperationKey("kXp_UeukUPbByMb1Pu$yS_gzhYg="),
  new OperationData.Builder()
  .withClientMethodDescriptor("(Ljava/lang/String;Ljava/lang/String;)Lcom/google/web/bindery/requestfactory/shared/Request;")
  .withDomainMethodDescriptor("(Ljava/lang/String;Ljava/lang/String;)Lcom/jonathanhester/gtvhub/server/UserDevice;")
  .withMethodName("createUserDevice")
  .withRequestContext("com.jonathanhester.gtvhub.shared.GtvhubRequest")
  .build());
withOperation(new OperationKey("0p9mBfDGH5ok6tUM_MuERKhxrJk="),
  new OperationData.Builder()
  .withClientMethodDescriptor("(Ljava/lang/Long;)Lcom/google/web/bindery/requestfactory/shared/Request;")
  .withDomainMethodDescriptor("(Ljava/lang/Long;)Lcom/jonathanhester/gtvhub/server/UserDevice;")
  .withMethodName("readUserDevice")
  .withRequestContext("com.jonathanhester.gtvhub.shared.GtvhubRequest")
  .build());
withOperation(new OperationKey("O2rkLNrO7Y$uhPPJF199xb8sxxo="),
  new OperationData.Builder()
  .withClientMethodDescriptor("(Lcom/jonathanhester/gtvhub/shared/UserDeviceProxy;)Lcom/google/web/bindery/requestfactory/shared/Request;")
  .withDomainMethodDescriptor("(Lcom/jonathanhester/gtvhub/server/UserDevice;)Lcom/jonathanhester/gtvhub/server/UserDevice;")
  .withMethodName("updateUserDevice")
  .withRequestContext("com.jonathanhester.gtvhub.shared.GtvhubRequest")
  .build());
withOperation(new OperationKey("gZ_egiA90O6qtnu0g7WruE5lvz4="),
  new OperationData.Builder()
  .withClientMethodDescriptor("()Lcom/google/web/bindery/requestfactory/shared/InstanceRequest;")
  .withDomainMethodDescriptor("()Ljava/lang/String;")
  .withMethodName("send")
  .withRequestContext("com.jonathanhester.gtvhub.client.MyRequestFactory$MessageRequest")
  .build());
withOperation(new OperationKey("heMJnKt$_WHJYIhjAVqaMoggHkU="),
  new OperationData.Builder()
  .withClientMethodDescriptor("()Lcom/google/web/bindery/requestfactory/shared/Request;")
  .withDomainMethodDescriptor("()Ljava/lang/String;")
  .withMethodName("getMessage")
  .withRequestContext("com.jonathanhester.gtvhub.client.MyRequestFactory$HelloWorldRequest")
  .build());
withOperation(new OperationKey("DzuNCss7_smJV7KpQQQqm57pCPU="),
  new OperationData.Builder()
  .withClientMethodDescriptor("()Lcom/google/web/bindery/requestfactory/shared/InstanceRequest;")
  .withDomainMethodDescriptor("()V")
  .withMethodName("register")
  .withRequestContext("com.jonathanhester.gtvhub.client.MyRequestFactory$RegistrationInfoRequest")
  .build());
withOperation(new OperationKey("GXj_MrOfySYHvCuKnShJew46e0k="),
  new OperationData.Builder()
  .withClientMethodDescriptor("()Lcom/google/web/bindery/requestfactory/shared/InstanceRequest;")
  .withDomainMethodDescriptor("()V")
  .withMethodName("unregister")
  .withRequestContext("com.jonathanhester.gtvhub.client.MyRequestFactory$RegistrationInfoRequest")
  .build());
withRawTypeToken("8KVVbwaaAtl6KgQNlOTsLCp9TIU=", "com.google.web.bindery.requestfactory.shared.ValueProxy");
withRawTypeToken("FXHD5YU0TiUl3uBaepdkYaowx9k=", "com.google.web.bindery.requestfactory.shared.BaseProxy");
withRawTypeToken("ax_WXJ_hkopK41nJOoNH1uUozzM=", "com.jonathanhester.gtvhub.shared.MessageProxy");
withRawTypeToken("5sAwrm0UvCKfTN$ZLZWdlwKGljA=", "com.jonathanhester.gtvhub.shared.RegistrationInfoProxy");
withRawTypeToken("h3axmKg64rb5VshN6VmyUjE9r0I=", "com.jonathanhester.gtvhub.shared.UserDeviceProxy");
withClientToDomainMappings("com.jonathanhester.gtvhub.server.Message", Arrays.asList("com.jonathanhester.gtvhub.shared.MessageProxy"));
withClientToDomainMappings("com.jonathanhester.gtvhub.server.RegistrationInfo", Arrays.asList("com.jonathanhester.gtvhub.shared.RegistrationInfoProxy"));
withClientToDomainMappings("com.jonathanhester.gtvhub.server.UserDevice", Arrays.asList("com.jonathanhester.gtvhub.shared.UserDeviceProxy"));
}}
