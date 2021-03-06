import Vue from 'vue';
import VueRouter from 'vue-router';

Vue.use(VueRouter);

const router = new VueRouter({
  mode: 'history',
  routes: [
    { path: '/', redirect: '/main' },
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
    { path: '/main', component: () => import('@/views/mains/MainPage.vue') },
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
      path: '/mypage/1/:usercode',
      component: () => import('@/views/mypage/MypagePage.vue'),
    },
    {
      path: '/mypage/0/:usercode',
      component: () => import('@/views/mypage/OwnerMypage.vue'),
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
    {
      path: '/community/tip/detail/:id',
      component: () => import('@/views/community/CommunityTipDetail.vue'),
    },
    {
      path: '/community/famousstore/detail/:id',
      component: () =>
        import('@/views/community/CommunityFamousStoreDetail.vue'),
    },
    {
      path: '/mystore/:usercode',
      component: () => import('@/views/stores/MyStorePage.vue'),
    },
  ],
  scrollBehavior(to, from, savedPosition) {
    if (savedPosition) {
      return savedPosition;
    } else {
      return { x: 0, y: 0 };
    }
  },
});

export default router;
