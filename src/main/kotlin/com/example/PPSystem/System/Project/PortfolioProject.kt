package com.example.PPSystem.System.Project

class PortfolioProject (_projectId: Int, _name: String, _description: String, _tecnologyStack: List<String>){

    val projectId: Int
    var name: String
    var description: String
    var tecnologyStack: List<String>

    init {
        projectId = _projectId
        name = _name
        description = _description
        tecnologyStack = _tecnologyStack
    }

}