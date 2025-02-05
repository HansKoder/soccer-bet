<template>
    <div>
        <header class="shadow-sm bg-white">
            
            <nav class="container mx-auto p-4 flex justify-between">
                <NuxtLink to="/" class="font-bold">Soccer Bet</NuxtLink>
                <ul class="flex gap-3">
                    <li>
                        <NuxtLink to="/" class="btn-active">Home</NuxtLink>
                    </li>
                    <li>
                        <NuxtLink to="/tournaments/">Tournaments</NuxtLink>
                    </li>
                </ul>
            </nav>
        </header>
    
        <!-- output the page content -->
        <div class="container mx-auto p-4">
            <slot />
        </div>


    </div>
</template>

<script setup>

</script>

<style scoped>

</style>