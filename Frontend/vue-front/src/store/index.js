import Vue from 'vue';
import Vuex from 'vuex';
import {
  getAuthFromCookie,
  getUserFromCookie,
  saveAuthToCookie,
  saveUserToCookie,
} from '@/utils/cookies';
// import { loginUser } from '@/api/auth';

Vue.use(Vuex);
export default new Vuex.Store({
  state: {
    username: getUserFromCookie() || '',
    token: getAuthFromCookie() || '',
    userimg: '',
    code: '',
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
    setCode(state, code) {
      state.code = code;
    },
  },
  actions: {
    async LOGIN({ commit }, userData) {
      console.log(userData);
      console.log(userData.nickname);
      commit('setToken', userData.accessToken);
      commit('setUsername', userData.nickname);
      commit('setUserimg', userData.profileImage);
      saveAuthToCookie(userData.accessToken);
      saveUserToCookie(userData.nickname);
      return userData;
    },
    async CODE({ commit }, codeData) {
      console.log(codeData);
      commit('setCode', codeData);
      return codeData;
    },
  },
});
