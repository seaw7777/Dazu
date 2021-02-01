import { instance } from './index';

function loginUser() {
  return instance.post('login');
}

function logoutUser(accessToken) {
  return instance.get('logout', accessToken);
}

export { loginUser, logoutUser };
