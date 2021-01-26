import Vue from 'vue';
import VueRouter from 'vue-router';

Vue.use(VueRouter);

const router = new VueRouter({
  mode: 'history',
  routes: [
    {
      path: '/login',
      component: () => import('@/views/accounts/LoginSignupPage.vue'),
    },
    {
      path: '/signup/choice',
      component: () => import('@/views/accounts/SignUserChoicePage.vue'),
    },
    {
      path: '/signup/ownerstep',
      component: () => import('@/views/accounts/OwnerStepPage.vue'),
    },
    {
      path: '/signup/customerstep',
      component: () => import('@/views/accounts/CustomerStepPage.vue'),
    },
  ],
});

export default router;
