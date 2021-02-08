import Vue from 'vue';
import VueRouter from 'vue-router';

Vue.use(VueRouter);

const router = new VueRouter({
  mode: 'history',
  routes: [
    { path: '/', redirect: '/user' },
    {
      path: '/user',
      component: () => import('@/views/accounts/LoginSignupPage.vue'),
    },
    {
      path: '/user/choice',
      component: () => import('@/views/accounts/SignUserChoicePage.vue'),
    },
    {
      path: '/user/ownerstep',
      component: () => import('@/views/accounts/OwnerStepPage.vue'),
    },
    {
      path: '/user/customerstep',
      component: () => import('@/views/accounts/CustomerStepPage.vue'),
    },
    { path: '/main', component: () => import('@/views/MainPage.vue') },
    {
      path: '/class/list',
      component: () => import('@/views/classes/ClassListPage.vue'),
    },
    {
      path: '/class/detail/:id',
      component: () => import('@/views/classes/ClassDetailPage.vue'),
    },
    {
      path: '/kakaoPaySuccess',
      component: () => import('@/views/classes/ClassPayPage.vue'),
    },
    {
      path: '/mypage/:usercode',
      component: () => import('@/views/mypage/MypagePage.vue'),
    },
    {
      path: '/community',
      component: () => import('@/views/community/CommunityPage.vue'),
    },
    {
      path: '/mealkit/list',
      component: () => import('@/views/mealkits/MealkitListPage.vue'),
    },
    {
      path: '/notice/list',
      component: () => import('@/views/notice/NoticeListPage.vue'),
    },
    {
      path: '/notice/detail/:noticecode',
      component: () => import('@/views/notice/NoticeDetailPage.vue'),
    },
    { path: '*', component: () => import('@/views/NotFoundPage.vue') },
  ],
});

export default router;
