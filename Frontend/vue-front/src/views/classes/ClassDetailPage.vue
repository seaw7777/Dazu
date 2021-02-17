<template>
  <div>
    <div class="breadcrumb-option">
      <div class="container">
        <div class="row">
          <div class="col-lg-6 col-md-6 col-sm-6">
            <div class="breadcrumb__text">
              <h2>Class detail</h2>
            </div>
          </div>
        </div>
      </div>
    </div>

    <section class="product-details spad">
      <div class="container">
        <div class="row">
          <div class="col-lg-8 col-md-6">
            <ClassShortDetail
              :classData="classdata"
              :imgurl="url"
            ></ClassShortDetail>

            <div class="product__details__tab">
              <div class="col-lg-12">
                <ul class="nav nav-tabs" role="tablist">
                  <li class="nav-item" v-for="item in items" :key="item.tab">
                    <a
                      class="nav-link"
                      data-toggle="tab"
                      :href="'#' + item.tab"
                      role="tab"
                      >{{ item.tab }}</a
                    >
                  </li>
                </ul>
                <div class="tab-content">
                  <div class="tab-pane active" id="클래스" role="tabpanel">
                    <div class="row d-flex justify-content-center">
                      <div class="col-lg-12">
                        <ClassIntroduce
                          :classcode="classdata.classcode"
                        ></ClassIntroduce>
                      </div>
                    </div>
                  </div>
                  <div class="tab-pane" id="가게" role="tabpanel">
                    <div class="row d-flex justify-content-center">
                      <div class="col-lg-12">
                        <StoreIntroduce :classdata="classdata"></StoreIntroduce>
                      </div>
                    </div>
                  </div>
                  <div class="tab-pane" id="밀키트" role="tabpanel">
                    <div class="row d-flex justify-content-center">
                      <div class="col-lg-12">
                        <MealkitInfo :classdata="classdata"></MealkitInfo>
                      </div>
                    </div>
                  </div>
                  <div class="tab-pane" id="후기" role="tabpanel">
                    <div class="row d-flex justify-content-center">
                      <div class="col-lg-12">
                        <ClassReviewList
                          :classdata="classdata"
                        ></ClassReviewList>
                      </div>
                    </div>
                  </div>
                  <div class="tab-pane" id="질문" role="tabpanel">
                    <div class="row d-flex justify-content-center">
                      <div class="col-lg-12">
                        <ClassQnA></ClassQnA>
                      </div>
                    </div>
                  </div>
                </div>
              </div>
            </div>
          </div>
          <div class="col-lg-4 col-md-6">
            <ClassChoiceForm :classData="classdata"></ClassChoiceForm>
          </div>
        </div>
      </div>
    </section>
  </div>
</template>

<script>
import ClassShortDetail from '@/components/classes/ClassShortDetail.vue';
import ClassIntroduce from '@/components/classes/ClassIntroduce.vue';
import StoreIntroduce from '@/components/classes/StoreIntroduce.vue';
import MealkitInfo from '@/components/classes/MealkitInfo.vue';
import ClassReviewList from '@/components/classes/ClassReviewList.vue';
import ClassQnA from '@/components/classes/ClassQnA.vue';
import ClassChoiceForm from '@/components/classes/ClassChoiceForm.vue';
import { fetchClass } from '@/api/classes';

export default {
  data() {
    return {
      url: '',
      tab: null,
      items: [
        { tab: '클래스' },
        { tab: '가게' },
        { tab: '밀키트' },
        { tab: '후기' },
        { tab: '질문' },
      ],
      classdata: {},
    };
  },
  components: {
    ClassShortDetail,
    ClassIntroduce,
    StoreIntroduce,
    MealkitInfo,
    ClassReviewList,
    ClassQnA,
    ClassChoiceForm,
  },
  async created() {
    if (!this.$store.getters.isLogin) {
      console.log('goto loginBtn');
      this.$router.push('/user');
    } else {
      this.$store.state.header = '1';
    }
    const id = this.$route.params.id;
    const { data } = await fetchClass(id);
    console.log(data);
    this.classdata = data;
    this.url =
      'https://i4d104.p.ssafy.io/dazu/file/image/' +
      this.classdata.classcode +
      '_class_Thumbnail';
  },
};
</script>

<style scoped>
.flex-container {
  display: flex;
  justify-content: center;
  padding: 10px;
  justify-items: stretch;
}
.tab-container {
  width: 80%;
}
.class-info {
  display: flex;
  flex-direction: column;
}
.secondary {
  padding: 1rem;
}
.secondary-a {
  background: white;
}
.secondary-b {
  height: 700px;
  color: white;
  background: #666;
}
.card-container {
  display: flex;
  justify-content: stretch;
}
</style>
