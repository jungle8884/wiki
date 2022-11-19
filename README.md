# 课程笔记

# 4-3 安装Vue ClI
npm get registry --显示当前的镜像网址
npm config set registry http://registry.npm.taobao.org --使用淘宝的镜像地址
# 版本保持一致
npm install -g @vue/cli@4.5.9
# 创建web
vue create web
# 成功及启动命令
`added 123 packages in 9s
⚓  Running completion hooks...

�  Generating README.md...

�  Successfully created project web.
�  Get started with the following commands:

 $ cd web
 $ npm run serve`


###
# 4-5 集成Ant Design Vue
# @nex: 安装最新的未正式发布版本
npm install ant-design-vue@next --save
# 版本保持一致
npm install ant-design-vue@2.0.0-rc.3 --save
# 文件回退: 选中文件 --> 鼠标右键 --> revert

###
# 4-6 将布局放到App.vue, 将各页面变化的部分放到各自路由页面
页面不一致如何解决: npm install ant-design-vue@next --save
解决没有搜索框: <a-layout-header id="components-layout-demo-top-side-2" class="header"> 
加 id: id="components-layout-demo-top-side-2"

###
# 4-7 勾选 Amend commit 追加到上一次提交

### 
# 5-2 集成HTTP库Axios
npm install axios@0.21.0 --save
# 5-3 Vue3数据绑定显示列表数据
响应式变量
ref() 或者 reactive(), 整个项目尽量只用其中的一种, 便于维护
# 5-4 电子书列表界面展示
使用Ant Design Vue组件展示
## 进入web --> 集成图标组件
npm install @ant-design/icon-vue@5.1.8 --save
# 5-5 Vue多环境配置, 增加dev和prod配置文件
编译和启动增加多环境命令

