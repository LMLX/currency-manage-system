<template>
    <div>
        <el-input v-model="todoMessage" placeholder="请输入内容"></el-input>
        <div class="el-dialog__footer">
            <span slot="footer" class="dialog-footer">
            <el-button @click="closeTodoMessageVisible">取 消</el-button>
            <el-button type="primary" @click="updateTodo">确 定</el-button>
        </span>
        </div>
    </div>
</template>
<script>
    export default {
        name: 'update-todo',
        props: {
            todoList: {},
            todoMessageVisible: {
                type: Object,
                required: true
            },
            updateIndex: 0,
        },
        data() {
            return {
                todoMessage: this.todoList[this.updateIndex].title
            }
        },
        methods: {
            closeTodoMessageVisible() {
                this.todoMessageVisible.updateShow = false;
            },
            updateTodo() {
                let todoMessage = this.todoMessage;
                if('' == todoMessage) {
                    return;
                }
                let todo = {title: todoMessage, status: false};
                this.todoList.splice(this.updateIndex, 1, todo);
                this.todoMessageVisible.updateShow = false;
            },
            updateDodoMessage(index) {
                this.todoMessage = this.todoList[index].title;
            },
        },
        created () {
            console.log('重新加载啦')
        }

    }
</script>
<style scoped>
    .el-dialog__footer {
        padding: 20px 0px 00px 0px;
        text-align: right;
        -webkit-box-sizing: border-box;
        box-sizing: border-box;
    }
</style>