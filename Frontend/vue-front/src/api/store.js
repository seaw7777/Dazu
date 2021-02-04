import { instance } from './index';

function fetchStore(dong) {
  return instance.get(`store/${dong}`);
}

export { fetchStore };
