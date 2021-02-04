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
  ],
});

export default router;
