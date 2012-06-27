package cachedemo

import grails.plugin.cache.CacheEvict
import grails.plugin.cache.Cacheable

class FooController {

    def grailsCacheManager

    @Cacheable('message')
    def lookup() {
       println "called 'lookup'"
       render text:"lookup"
    }

    @CacheEvict(value='message', allEntries=true)
    def evict() {
       println "called 'evict'"
       render text:"evict"
    }

    def edit(){
        this.clearCache()
        render text:"cleared?"
    }

    private void clearCache(){
        def cache = grailsCacheManager.getCache('message')
        cache.clear()
    }

    def tags(){
        
    }

    def tagsClear(){
        def cache = grailsCacheManager.getCache('grailsBlocksCache')
        if(params.key!=null){
            def keys = cache.getNativeCache().getKeys()
            keys.each{
                if(it.contains(params.key)){
                    cache.evict(it)
                }
            }
        }else{
            cache.clear()
        }
    }

    def watchCache(){
        grailsCacheManager.getCacheNames().each{
            println it
        }
    }
}
