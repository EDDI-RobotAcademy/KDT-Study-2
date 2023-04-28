<template lang="">
    <div>
        <table>
            <tr>
                <td>상품명</td>
                <td>
                    <input type="text" v-model="productId" readonly/>   
                </td>
            </tr>
            <tr>
                <td>상품가격</td>
                <td>
                    <input type="text" v-model="price" readonly/>
                </td>
            </tr>
            <tr>
                <td>제조사</td>
                <td>
                    <input type="text" v-model="company" readonly/>
                </td>
            </tr>
            <tr>
                <td>제조일</td>
                <td>
                    <input type="text" v-model="manufactureDate" readonly/>
                </td>
            </tr>
            <tr>
                <td>상품카테고리</td>
                <td>
                    <input type="text" v-model="category" readonly/>
                </td>
            </tr>
        </table>
    </div>
</template>

<script>
export default {
    name: "ProductReadForm",
    props: {
        board: {
            type: Object,
            required: true,
        }
    }
}

</script>

<style lang="">

</style>
