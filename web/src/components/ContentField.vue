<template>
    <!--插入一个白框，由于这个白框是公共的，因此可以作为一个component-->
    <div class="conrainer content-field">
        <div class="card">
            <div class="card-body">
                <!--存放要填充的内容-->
                <slot></slot>
            </div>
        </div>
    </div>

</template>

<script>

</script>

<style scoped>
/*修改content-field的样式 */
div.content-field{
    margin-top: 20px;
}
</style>