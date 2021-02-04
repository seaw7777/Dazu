<template>
  <div>
    <div class="flex-container">
      <div>
        <aside class="secondary secondary-a class-info">
          <ClassShortDetail :classData="classdata"></ClassShortDetail>
        </aside>

        <v-card>
          <v-tabs v-model="tab" background-color="primary" dark>
            <v-tab v-for="item in items" :key="item.tab">
              {{ item.tab }}
            </v-tab>
          </v-tabs>

          <v-tabs-items v-model="tab">
            <v-tab-item v-for="item in items" :key="item.tab">
              <v-card flat v-if="item.tab === '클래스 소개'">
                <v-card-text class="card-container"
                  ><ClassIntroduce></ClassIntroduce
                ></v-card-text>
              </v-card>
              <v-card flat v-else-if="item.tab === '가게소개'">
                <v-card-text class="card-container"
                  ><StoreIntroduce></StoreIntroduce>
                </v-card-text>
              </v-card>
              <v-card flat v-else-if="item.tab === '밀키트 정보'">
                <v-card-text class="card-container"
                  ><MealkitInfo></MealkitInfo>
                </v-card-text>
              </v-card>
              <v-card flat v-else-if="item.tab === '후기'">
                <v-card-text class="card-container"
                  ><ClassReviewList :classdata="classdata"></ClassReviewList>
                </v-card-text>
              </v-card>
              <v-card flat v-else-if="item.tab === '공지사항'">
                <v-card-text class="card-container"
                  ><ClassNotice></ClassNotice>
                </v-card-text>
              </v-card>
            </v-tab-item>
          </v-tabs-items>
        </v-card>
      </div>
      <aside class="secondary secondary-b">
        <ClassChoiceForm :classData="classdata"></ClassChoiceForm>
      </aside>
    </div>
  </div>
</template>

<script>
import ClassShortDetail from '@/components/classes/ClassShortDetail.vue';
import ClassIntroduce from '@/components/classes/ClassIntroduce.vue';
import StoreIntroduce from '@/components/classes/StoreIntroduce.vue';
import MealkitInfo from '@/components/classes/MealkitInfo.vue';
import ClassReviewList from '@/components/classes/ClassReviewList.vue';
import ClassNotice from '@/components/classes/ClassNotice.vue';
import ClassChoiceForm from '@/components/classes/ClassChoiceForm.vue';
import { fetchClass } from '@/api/classes';
export default {
  data() {
    return {
      tab: null,
      items: [
        { tab: '클래스 소개' },
        { tab: '가게소개' },
        { tab: '밀키트 정보' },
        { tab: '후기' },
        { tab: '공지사항' },
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
    ClassNotice,
    ClassChoiceForm,
  },
  async created() {
    const id = this.$route.params.id;
    // console.log(id);
    const { data } = await fetchClass(id);
    console.log(data);
    this.classdata = data;
  },
};
</script>

<style scoped>
.flex-container {
  display: flex;
  justify-content: space-between;
  padding: 10px;
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
  color: white;
  background: #666;
}
.card-container {
  display: flex;
  justify-content: center;
}
</style>
