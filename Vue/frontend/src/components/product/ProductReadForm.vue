<template lang="">
    <div>
        <table>
            <tr>
                <td>상품명</td>
                <td>
                    <input type="text" v-model="product.name" readonly/>   
                </td>
            </tr>
            <tr>
                <td>상품가격</td>
                <td>
                    <input type="text" v-model="product.price" readonly/>
                </td>
            </tr>
            <tr>
                <td>제조사</td>
                <td>
                    <input type="text" v-model="product.company" readonly/>
                </td>
            </tr>
            <tr>
                <td>제조일</td>
                <td>
                    <input type="text" v-model="product.manufactureDate" readonly/>
                </td>
            </tr>
            <tr>
                <td>상품카테고리</td>
                <td>
                    <input type="text" v-model="product.category" readonly/>
                </td>
            </tr>
        </table>
    </div>
</template>

<script>
export default {
    name: "ProductReadForm",
    props: {
        product: {
            type: Object,
            required: true,
        }
    }
}

</script>

<style lang="">

</style>
