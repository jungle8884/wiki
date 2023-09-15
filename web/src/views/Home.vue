<template>
    <a-layout>

      <a-layout-sider width="200" style="background: #ffffff">
            <a-menu
              mode="inline"
              :style="{ height: '100%', borderRight: 0 }"
            >
              <a-sub-menu key="sub1">
                <template #title>
                  <span>
                    <user-outlined />
                    subnav 1
                  </span>
                </template>
                <a-menu-item key="1">option1</a-menu-item>
                <a-menu-item key="2">option2</a-menu-item>
                <a-menu-item key="3">option3</a-menu-item>
                <a-menu-item key="4">option4</a-menu-item>
              </a-sub-menu>
              <a-sub-menu key="sub2">
                <template #title>
                  <span>
                    <laptop-outlined />
                    subnav 2
                  </span>
                </template>
                <a-menu-item key="5">option5</a-menu-item>
                <a-menu-item key="6">option6</a-menu-item>
                <a-menu-item key="7">option7</a-menu-item>
                <a-menu-item key="8">option8</a-menu-item>
              </a-sub-menu>
              <a-sub-menu key="sub3">
                <template #title>
                  <span>
                    <notification-outlined />
                    subnav 3
                  </span>
                </template>
                <a-menu-item key="9">option9</a-menu-item>
                <a-menu-item key="10">option10</a-menu-item>
                <a-menu-item key="11">option11</a-menu-item>
                <a-menu-item key="12">option12</a-menu-item>
              </a-sub-menu>
            </a-menu>
      </a-layout-sider>

      <a-layout-content
        :style="{ background: '#fff', padding: '24px', margin: 0, minHeight: '280px' }"
      >
          <!--【数据绑定ebooks | ebooksReactive】 使用 Vue3 ref 实现数据绑定 4 |gutter: 20 间距20px| column 代表列数【column: 3 表示一行显示3列】-->
          <a-list item-layout="vertical" size="large" :grid="{ gutter: 20, column: 3 }" :data-source="ebooks">
              <!-- item 表示ebooks数组中的某一个元素 -->
              <template #renderItem="{ item }">
                  <!--电子书 名字【name】-->
                  <a-list-item key="item.name">
                      <!--【图标】-->
                      <template #actions>
                          <span v-for="{ type, text } in actions" :key="type">
                            <component v-bind:is="type" style="margin-right: 8px" />
                            {{ text }}
                          </span>
                      </template>
                      <!-- 描述【description】-->
                      <a-list-item-meta :description="item.description">
                          <!-- 标题【title： 使用 图书名->name】-->
                          <template #title>
                              <a :href="item.href">{{ item.name }}</a>
                          </template>
                          <!-- 图标【cover：数据库ebook表中对应字段cover】-->
                          <template #avatar><a-avatar :src="item.cover"/></template>
                      </a-list-item-meta>
                  </a-list-item>
              </template>
          </a-list>
      </a-layout-content>

    </a-layout>
</template>

<script lang="ts">
  import { defineComponent, onMounted, ref, reactive, toRef } from 'vue';
  import axios from 'axios';

  // any 回到js的弱类型
  const listData: any = [];
  for (let i = 0; i < 23; i++) {
      listData.push({
          href: 'https://www.antdv.com/',
          title: `ant design vue part ${i}`,
          avatar: 'https://zos.alipayobjects.com/rmsportal/ODTLcjxAfvqbxHnVXCYX.png',
          description:
              'Ant Design, a design language for background applications, is refined by Ant UED Team.',
          content:
              'We supply a series of design principles, practical patterns and high quality design resources (Sketch and Axure), to help people create their product prototypes beautifully and efficiently.',
      });
  }


  export default defineComponent({
    name: 'home',
      // Vue3新增的初始化方法【替代了Vue2的data()、mounted()、methods()】
    setup() {
      console.log("setup");

      const ebooks = ref(); // 使用 Vue3 ref 实现数据绑定 1
      // const ebooksReactive = reactive({books: []});

        // 【一般是初始化工作】生命周期函数: 先输出setup, 再渲染页面, 再输出onMounted
      onMounted(() => {
        console.log("onMounted");
            // get获取数据 then回调函数
        axios.get("/ebook/list").then((response) => {
          const data = response.data; // 使用 Vue3 ref 实现数据绑定 2
          ebooks.value = data.content;
          // ebooksReactive.books = data.content;
        });
      });

      return {
        ebooks, // 使用 Vue3 ref 实现数据绑定 3 【return ebooks 后 页面就可以拿到数据了】
          // ebooksReactive: toRef(ebooksReactive, "books"),
        listData,
        pagination: {
            onChange: (page: any) => {
                console.log(page);
            },
            pageSize: 3,
        },
        actions: [
            { type: 'StarOutlined', text: '156' },
            { type: 'LikeOutlined', text: '156' },
            { type: 'MessageOutlined', text: '2' },
        ],
      }
    }
  });
</script>

<style scoped>
    .ant-avatar {
        width: 50px;
        height: 50px;
        line-height: 50px;
        border-radius: 8%;
        margin: 5px 0;
    }
</style>