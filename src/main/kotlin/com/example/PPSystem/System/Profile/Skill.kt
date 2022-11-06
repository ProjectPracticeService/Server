package com.example.PPSystem.System.Profile

class Skill (_skillId: Int, _name: String, _experience: String, _proficiencyLevel: com.example.PPSystem.System.Profile.ProficiencyLevel){

    var skillId: Int
    var name: String
    var experience: String
    var proficiencyLevel: com.example.PPSystem.System.Profile.ProficiencyLevel

    init {
        skillId = _skillId
        name = _name
        experience = _experience
        proficiencyLevel = _proficiencyLevel

    }

}