package ru.mephi.pp.models.profile

class Skill(_skillId: Int, _name: String, _experience: String, _proficiencyLevel: ProficiencyLevel) {

    var skillId: Int
    var name: String
    var experience: String
    var proficiencyLevel: ProficiencyLevel

    init {
        skillId = _skillId
        name = _name
        experience = _experience
        proficiencyLevel = _proficiencyLevel
    }

}