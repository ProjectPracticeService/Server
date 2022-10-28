class EducationalOrganization (_organizationId: Int, _name: String, _city: Int){

    val organizationId: Int
    var name: String
    var city: Int

    init {
        organizationId = _organizationId
        name = _name
        city = _city
    }

}