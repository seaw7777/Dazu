import Vue from 'vue';
import Vuex from 'vuex';
import {
  getAuthFromCookie,
  getUserFromCookie,
  getImgFromCookie,
  getUserCodeFromCookie,
  getUserTypeFromCookie,
  saveAuthToCookie,
  saveUserToCookie,
  saveImgToCookie,
  saveUserCodeToCookie,
  saveUserTypeToCookie,
} from '@/utils/cookies';

Vue.use(Vuex);
export default new Vuex.Store({
  state: {
    username: getUserFromCookie() || '',
    token: getAuthFromCookie() || '',
    userimg: getImgFromCookie() || '',
    code: '',
    address: '',
    usercode: getUserCodeFromCookie() || '',
    usertype: getUserTypeFromCookie() || '',
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
    setToken(state, token) {
      state.token = token;
    },
    setUserimg(state, userimg) {
      state.userimg = userimg;
    },
    setAddress(state, address) {
      state.address = address;
    },
    setUserCode(state, usercode) {
      state.usercode = usercode;
    },
    setUserType(state, usertype) {
      state.usercode = usertype;
    },
    clearUsername(state) {
      state.username = '';
    },
    clearToken(state) {
      state.token = '';
    },
    clearUserimg(state) {
      state.username = '';
    },
    clearUserCode(state) {
      state.usercode = '';
    },
    clearUserType(state) {
      state.usertype = '';
    },
  },
  actions: {
    async LOGIN({ commit }, userData) {
      console.log(userData.nickname);
      commit('setToken', userData.accessToken);
      commit('setUsername', userData.nickname);
      commit('setUserimg', userData.profileImage);
      commit('setUserCode', userData.usercode);
      commit('setUserType', userData.usertype);
      saveAuthToCookie(userData.accessToken);
      saveUserToCookie(userData.nickname);
      saveImgToCookie(userData.profileImage);
      saveUserCodeToCookie(userData.usercode);
      saveUserTypeToCookie(userData.usertype);
      return userData;
    },
    async CODE({ commit }, codeData) {
      console.log(codeData);
      commit('setCode', codeData);
      return codeData;
    },
    async ROAD({ commit }, address) {
      console.log(address);
      commit('setAddress', address);
      return address;
    },
  },
});
