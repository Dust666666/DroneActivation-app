# DroneActivation 项目开发文档

## 1. 项目目标
- 构建一个 Android 端无人机实名/激活工具。
- 当前目标是先完成本地 UI 原型，后续再接入无人机连接、实名校验、激活、注销等真实流程。

## 2. 当前目录结构
```text
DroneActivation-app/
|- app/
|  |- src/main/
|  |  |- java/com/drone/activation/
|  |  |  |- MainActivity.kt
|  |  |  |- model/UiState.kt
|  |  |  |- ui/ActivationScreen.kt
|  |  |  `- ui/theme/
|  |  |- res/values/
|  |  `- AndroidManifest.xml
|  |- build.gradle.kts
|  `- proguard-rules.pro
|- gradle/wrapper/
|- build.gradle.kts
|- settings.gradle.kts
|- gradle.properties
|- local.properties
`- PROJECT_DEV.md
```

## 3. 完成的功能
- Android 工程可构建，`app/build/outputs/apk/debug/` 已有调试包产物。
- 已完成单页 Compose 界面骨架：
  - IP 输入
  - 连接按钮
  - SN / 实名状态 / 激活状态展示
  - 实名校验、激活、注销按钮
- 已有基础状态模型 `UiState`，并在 `MainActivity` 中用 `remember + mutableStateOf` 管理。
- 已声明 `INTERNET` 权限，为后续联网流程预留。

## 4. 正在开发的功能
- 无人机连接逻辑：`onConnect` 目前未实现。
- SN 获取、实名状态查询、激活状态查询：当前只有占位字段。
- 实名校验、激活、注销业务：按钮回调已预留，但仍是空实现。
- 联网/协议接入：注释显示后续计划接入 HTTP 与 MAVLink。
- Python 集成：根 `build.gradle.kts` 与 `app/build.gradle.kts` 中保留了 `Chaquopy` 注释，说明有过或计划中的 Python 嵌入方向。

## 5. 关键技术
- Kotlin 2.0.21
- Android Gradle Plugin 8.7.3
- Jetpack Compose + Material 3
- minSdk 29 / targetSdk 35 / compileSdk 35
- Java 17
- Gradle Kotlin DSL

## 6. 已知的问题
- 多处中文出现乱码，明显存在文件编码问题，已影响 UI 文案、默认状态值和注释可读性。
- `.gitignore` 文件名为 `.gitignore.txt`，Git 不会按预期生效，导致 `.gradle/`、`.idea/` 等生成文件已出现在工作区改动中。
- `ui/theme/Color.kt`、`Theme.kt`、`Type.kt` 为空，主题层尚未真正建立。
- 还没有数据层、ViewModel、仓库层、网络层和测试代码。
- `local.properties` 存在本机 SDK 路径，仅限本地开发使用，不应作为跨环境配置依据。

## 7. 主要文件说明
- `app/src/main/java/com/drone/activation/MainActivity.kt`
  - 应用入口，持有页面状态并渲染主界面。
- `app/src/main/java/com/drone/activation/ui/ActivationScreen.kt`
  - 激活页 UI 骨架，所有业务按钮回调都已预留。
- `app/src/main/java/com/drone/activation/model/UiState.kt`
  - 页面状态模型，保存 IP、SN、实名状态、激活状态。
- `app/src/main/AndroidManifest.xml`
  - 应用清单，声明启动页与网络权限。
- `app/build.gradle.kts`
  - App 模块构建配置，定义 SDK、Compose、Java 17 与依赖。
- `gradle/libs.versions.toml`
  - 版本清单，目前仅覆盖 Android / Compose 基础依赖。

## 8. 下一步要做什么
1. 先统一修复所有源码文件的 UTF-8 编码，恢复中文可读性。
2. 补齐真正的 `.gitignore`，清理不该跟踪的构建产物和 IDE 文件。
3. 引入 `ViewModel`，把页面状态从 `Activity` 中拆出。
4. 实现连接流程，至少打通“输入 IP -> 发起连接 -> 返回状态”闭环。
5. 明确协议方案：HTTP、MAVLink、或 Python 桥接，避免三条路线并行发散。
6. 为实名校验/激活/注销补上接口层与错误处理。

## 9. 不能改动或需要注意的约束
- `applicationId` / `namespace` 当前均为 `com.drone.activation`，若无明确迁移计划，不要随意修改。
- 开发环境基线是 Java 17、Compose、minSdk 29，新增依赖和代码需与此兼容。
- `build/`、`.gradle/`、`.idea/`、`local.properties` 都属于环境/生成内容，不应作为业务源码维护重点。
- 当前功能判断主要依据现有代码推断，“正在开发的功能”包含对注释和预留回调的合理推断，不代表后端或协议层已存在。
- 在未确认协议与设备交互方式前，不建议大改 UI 结构，优先保证连接与状态流转能闭环。
