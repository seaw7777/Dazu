<template>
  <div>
    <vc-calendar :attributes="attributes" is-double-paned>
      <!--===============TODO ROW SLOT==============-->
      <div slot="todo-row" slot-scope="{ customData }" class="todo-row">
        <!--Todo content-->
        <div class="todo-content">
          <!--Show textbox when editing todo-->
          <input
            class="todo-input"
            v-if="customData.id === editId"
            v-model="customData.description"
            @keyup.enter="editId = 0"
            v-focus-select
          />
          <!--Show status/description when not editing-->
          <span v-else>
            <!--Completed checkbox-->
            <input type="checkbox" v-model="customData.isComplete" />
            <!--Description-->
            <span
              :class="['todo-description', { complete: customData.isComplete }]"
              @click="toggleTodoComplete(customData)"
            >
              {{ customData.description }}
            </span>
          </span>
        </div>
        <!--Edit/Done buttons-->
        <a @click.prevent="toggleTodoEdit(customData)">
          <!--Edit button-->
          <b-icon
            v-if="editId !== customData.id"
            icon="pencil"
            type="is-info"
            size="is-small"
          >
          </b-icon>
          <!--Done button-->
          <b-icon v-else icon="check" type="is-success" size="is-small">
          </b-icon>
        </a>
        <!--Delete button-->
        <a
          @click.prevent="deleteTodo(customData)"
          v-if="!editId || editId !== customData.id"
          class="delete-todo"
        >
          <b-icon icon="trash" type="is-danger" size="is-small"> </b-icon>
        </a>
      </div>
    </vc-calendar>
  </div>
</template>

<script>
// import { fetchClassTime } from '@/api/classes';
const color = '#ff8080';
const todos = [
  {
    id: 1,
    description: 'Take Noah to basketball practice.',
    isComplete: false,
    dates: new Date(2021, 1, 5),
  },
];

export default {
  data() {
    return {
      incId: todos.length,
      editId: 0,
      todos,
    };
  },
  computed: {
    attributes() {
      return [
        // Today attribute
        {
          contentStyle: {
            fontWeight: '700',
            color: '#66b3cc',
          },
          dates: new Date(),
        },
        // Todo attributes
        ...this.todos.map(todo => ({
          key: todo.id,
          dates: todo.dates,
          customData: todo,
          order: todo.id,
          dot: {
            backgroundColor: color,
            opacity: todo.isComplete ? 0.3 : 1,
          },
          popover: {
            slot: 'todo-row', // Matches slot from above
            visibility: 'focus',
          },
        })),
      ];
    },
  },
  methods: {
    toggleTodoComplete(todo) {
      todo.isComplete = !todo.isComplete;
    },
    toggleTodoEdit(todo) {
      this.editId = this.editId === todo.id ? 0 : todo.id;
    },
    deleteTodo(todo) {
      this.todos = this.todos.filter(t => t !== todo);
    },
  },
  directives: {
    focusSelect: {
      inserted(el) {
        el.focus();
        el.select();
      },
    },
  },
};
</script>

<style scoped>
.calendar-container {
  display: flex;
  flex-direction: column;
}
</style>
