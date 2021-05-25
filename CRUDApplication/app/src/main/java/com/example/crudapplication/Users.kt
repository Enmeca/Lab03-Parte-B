package com.example.crudapplication

class Users private constructor() {

    private var users : ArrayList<User> = ArrayList<User>()

    init{
        addUser(User("philippe09", "12345", "Philippe"))
        addUser(User("enrique12", "123", "Enrique"))
    }

    private object HOLDER {
        val INSTANCE = Users()
    }

    companion object {
        val instance: Users by lazy{
            HOLDER.INSTANCE
        }
    }

    fun addUser(user: User){
        users?.add(user)
    }

    fun getUser(name: String): User? {
        for (u: User in users!!){
            if(u.name.equals(name)){
                return u;
            }
        }
        return null;
    }

    fun getUsers(): ArrayList<User>{
        return this.users!!
    }

    fun login(user: String?, password: String?): Boolean{
        for(p: User in users!!){
            if(p.user.equals(user) && p.password.equals(password)){
                return true
            }
        }
        return false
    }

    fun loginP(user: String?, password: String?): User?{
        for(p: User in users!!){
            if(p.user.equals(user) && p.password.equals(password)){
                return p
            }
        }
        return null
    }

    fun deleteUser(position: Int){
        users!!.removeAt(position)
    }

    fun editUser(u: User, position: Int){
        var aux = users!!.get(position)
        aux.password = u.password
        aux.name = u.name
        aux.user = u.user
    }
}