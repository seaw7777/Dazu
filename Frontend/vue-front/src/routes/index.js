import Vue from 'vue';
import VueRouter from 'vue-router';

Vue.use(VueRouter);

const router = new VueRouter({
  mode: 'history',
  routes: [
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
  ],
});

export default router;
