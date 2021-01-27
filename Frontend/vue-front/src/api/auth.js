import { instance } from './index';

function loginUser() {
  return instance.post('login');
}

export { loginUser };
