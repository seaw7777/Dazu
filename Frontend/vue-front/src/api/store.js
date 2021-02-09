import { instance } from './index';

function fetchStore(dong) {
  return instance.get(`store/list/${dong}`);
}

export { fetchStore };
