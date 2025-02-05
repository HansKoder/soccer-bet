<template>
    <div>
        <h1>Tournament {{ id }} </h1>
    </div>
</template>

<script setup>
    const { id } = useRoute().params;

    definePageMeta({
        layout: 'tournaments'
    })
</script>

<style scoped>

</style>