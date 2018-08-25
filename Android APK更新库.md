### Android APK更新库

#### 1、基本流程

- 版本更新检测
- 版本比对
- APK下载
- APK安装

####  2、需求

- 功能性需求
  - 支持自定义对话框；
  - 支持自定义通知栏；
  - 支持静默下载；
  - 支持强制更新；
  - 支持静默安装；
  - 支持网络环境判断；
  - 支持增量更新（补丁）；
  - 支持多APK多线程更新；
  - 支持断点续载；
  - 支持暂停下载；
  - 适配多版本；
  - 权限动态申请；
  - 支持下载失败重试；
  - MD5校验安装包；
  - 自定义下载路径；
  - 
- 非功能性需求
  - 调用简洁；
  - 扩展性强；
  - 

#### 3、技术选型

- 网络请求
  - OkHttp
- 异步处理
  - RxJava
- 
  - 

#### 4、参考

- 第三方库
  - [CheckVersionLib](https://github.com/AlexLiuSheng/CheckVersionLib)
  - [UpdateAppDemo](https://github.com/teprinciple/UpdateAppDemo)
  - [android-auto-update](https://github.com/feicien/android-auto-update)
- 博客
  - [Android运维](https://www.jianshu.com/p/d2611f4462f8)
  - [Android在线更新那点事儿（适配6.0、7.0、8.0）](https://juejin.im/post/5ae3d40bf265da0b886d29f9)
  - [真正的APK增量更新方案ApkDiffPatch](https://blog.csdn.net/housisong/article/details/79768678)
  - [开发第三方库最佳实践](https://juejin.im/entry/574da0742e958a005efd9114)
  - [关于日益泛滥的Android第三方框架](https://aspook.com/2016/10/25/%E5%85%B3%E4%BA%8E%E6%97%A5%E7%9B%8A%E6%B3%9B%E6%BB%A5%E7%9A%84Android%E7%AC%AC%E4%B8%89%E6%96%B9%E6%A1%86%E6%9E%B6/)
  - [Android模块化开发](https://www.jianshu.com/p/0ea37b2c7ce7)
  - 
- 







