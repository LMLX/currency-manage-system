<template>
    <div class="container">
        <el-container>
            <el-aside width="400px">
                <div class="custom-tree-container">
                    <div class="block">
                        <el-tree
                                :data="data"
                                node-key="id"
                                default-expand-all
                                :expand-on-click-node="false">
                <span class="custom-tree-node" slot-scope="{ node, data }">
                    <span>{{ node.label }}</span>
                    <span>
                    <el-button
                            type="text"
                            size="mini"
                            @click="() =>append(data)">
                      增加
                    </el-button>
                    <el-button
                            type="text"
                            size="mini"
                            @click="() => remove(node, data)">
                      删除
                    </el-button>
                    </span>
                </span>
                        </el-tree>
                    </div>
                </div>
            </el-aside>
            <el-main>Main</el-main>
        </el-container>

    </div>

</template>

<script>

    export default {
        name: 'department',
        data() {
            const data = [{
                id: 1,
                label: '一级 1',
                children: [{
                    id: 4,
                    label: '二级 1-1',
                    children: [{
                        id: 9,
                        label: '三级 1-1-1'
                    }, {
                        id: 10,
                        label: '三级 1-1-2'
                    }]
                }]
            }];
            return {
                data: JSON.parse(JSON.stringify(data)),
                data: JSON.parse(JSON.stringify(data))
            }
        },

        methods: {
            append(data) {
                const newChild = {id: id++, label: 'testtest', children: []};
                if (!data.children) {
                    this.$set(data, 'children', []);
                }
                data.children.push(newChild);
            },

            remove(node, data) {
                const parent = node.parent;
                const children = parent.data.children || parent.data;
                const index = children.findIndex(d => d.id === data.id);
                children.splice(index, 1);
            },

            renderContent(h, {node, data, store}) {
                return (
                    '<span class="custom-tree-node">' +
                    '<span>{node.label}</span>' +
                    '<span>' +
                    '<el-button size="mini" type="text" on-click={ () => this.append(data) }>Append</el-button>' +
                    '<el-button size="mini" type="text" on-click={ () => this.remove(node, data) }>Delete</el-button>' +
                    '</span>' +
                    '</span>'
                );
            }
        }
    };
</script>

<style scoped>
    .custom-tree-node {
        flex: 1;
        display: flex;
        align-items: center;
        justify-content: space-between;
        font-size: 14px;
        padding-right: 8px;
    }
    .el-aside {
        background-color: #D3DCE6;
        text-align: center;
    }

    .el-main {
        background-color: #E9EEF3;
        text-align: center;
    }
</style>
