import { instance } from './index';

function loginUser() {
  console.log('go api');
  return instance.post('login');
}

export { loginUser };
