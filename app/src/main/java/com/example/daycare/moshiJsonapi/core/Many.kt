package com.example.daycare.moshiJsonapi.core

abstract class Many<T : Resource> : Resource(), List<T> {
    @Transient
    private val list = ArrayList<T>()
    override val size: Int
        get() = list.size

    override fun contains(element: T) = list.contains(element)

    override fun containsAll(elements: Collection<T>) = list.containsAll(elements)

    override fun get(index: Int) = list[index]

    override fun indexOf(element: T) = list.indexOf(element)

    override fun isEmpty() = list.isEmpty()

    override fun iterator() = list.iterator()

    override fun lastIndexOf(element: T) = list.lastIndexOf(element)

    override fun listIterator() = list.listIterator()

    override fun listIterator(index: Int) = list.listIterator(index)

    override fun subList(fromIndex: Int, toIndex: Int) = list.subList(fromIndex, toIndex)

    abstract fun getEmpty():T

    fun create(): ResourceIdentifier {
        val newInstance = getEmpty()
        list.add(newInstance)
        return newInstance
    }
}