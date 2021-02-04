<template>
  <div>
    <v-container>
      <v-row no-gutters>
        <v-btn depressed>
          작성
        </v-btn>
        <v-text-field :rules="rules"></v-text-field>
        <br /><br />
        <v-expansion-panels class="mb-6">
          <v-expansion-panel v-for="(qna, i) in qnas" :key="i">
            <v-expansion-panel-header>
              {{ qna.member_nickname }}
              <template v-slot:actions>
                <v-icon color="primary">
                  $expand
                </v-icon>
              </template>
            </v-expansion-panel-header>
            <v-expansion-panel-content>
              {{ qna.class_qna_board_write_contents }} &nbsp;
            </v-expansion-panel-content>
          </v-expansion-panel>
        </v-expansion-panels>
      </v-row>
    </v-container>
  </div>
</template>

<script>
import { fetchClassQnA } from '@/api/classes';
export default {
  data() {
    return {
      qnas: [
        {
          member_nickname: '히히',
          class_qna_board_write_contents: '넹?',
        },
      ],
    };
  },
  async created() {
    const id = this.$route.params.id;
    console.log(id);
    const { data } = await fetchClassQnA(id);
    this.qnas = data;
    console.log(data);
  },
};
</script>

<style></style>
