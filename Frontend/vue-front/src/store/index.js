import Vue from 'vue';
import Vuex from 'vuex';
import {
  getAuthFromCookie,
  getUserFromCookie,
  saveAuthToCookie,
  saveUserToCookie,
} from '@/utils/cookies';
import { loginUser } from '@/api/auth';

Vue.use(Vuex);
export default new Vuex.Store({
  state: {
    username: getUserFromCookie() || '',
    token: getAuthFromCookie() || '',
    userimg: '',
  },
  getters: {
    isLogin(state) {
      return state.username !== '';
    },
  },
  mutations: {
    setUsername(state, username) {
      state.username = username;
    },
    clearUsername(state) {
      state.username = '';
    },
    setToken(state, token) {
      state.token = token;
    },
    clearToken(state) {
      state.token = '';
    },
    setUserimg(state, userimg) {
      state.userimg = userimg;
    },
  },
  actions: {
    async LOGIN({ commit }) {
      const { data } = await loginUser();
      console.log(data);
      commit('setToken', data.accessToken);
      commit('setUsername', data.nickname);
      commit('setUserimg', data.profileImage);
      saveAuthToCookie(data.accessToken);
      saveUserToCookie(data.nickname);
      return data;
    },
  },
});
