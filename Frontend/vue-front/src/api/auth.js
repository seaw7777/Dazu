import { instance } from './index';

// 로그아웃 API
function logoutUser(accessToken) {
  return instance.get(`logout/${accessToken}`);
}

export { logoutUser };
