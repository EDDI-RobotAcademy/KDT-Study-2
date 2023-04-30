<template lang="">
    <div>
        <h3>상품 목록</h3>
        <p></p>
        <table>
            <tr>
                <td align="center" width="2%">상품명</td>
                <td align="center" width="2%">상품가격</td>
                <td align="center" width="2%">제조사</td>
                <td align="center" width="2%">유통기한</td>
                <td align="center" width="2%">제조일</td>
            </tr>
            <p></p>
            <tr v-if="!products || (Array.isArray(products) && products.length === 0)">
                <td colspan="5">
                    현재 등록된 상품이 없습니다!
                </td>
            </tr>
            <tr v-else v-for="product in products" :key="product.productId">
                <td>
                    <router-link :to="{
                        name: 'ProductReadPage',
                        params: { productId: product.productId.toString() }}">
                        {{ product.name }}
                    </router-link>
                </td>
                <td>
                    {{ product.price }}
                </td>
                <td>
                    {{ product.company }}
                </td>
                <td>
                    {{ product.expDate }}
                </td>
                <td>
                    {{ product.manufactureDate }}
                </td>
            </tr>
        </table>
    </div>
</template>

<script>
export default {
    props: {
        products: {
            type: Array
        }
    }

}
</script>
<style scoped>
@import url('https://fonts.googleapis.com/css2?family=Song+Myung&display=swap');

h3 {
    color: darkslateblue;
    font-family: 'Song Myung', serif;
    text-shadow: 4px 4px 4px cornflowerblue;
    font-size: 40px;
}

table {
    border: 4px solid mediumpurple;
    font-family: 'Song Myung', serif;
    font-size: 20px;
}

td {
    border: 2px solid lightskyblue;
}
</style>