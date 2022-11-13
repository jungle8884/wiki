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
# 页面不一致如何解决: npm install ant-design-vue@next --save
# 解决没有搜索框: <a-layout-header id="components-layout-demo-top-side-2" class="header"> 
# 加 id: id="components-layout-demo-top-side-2"

