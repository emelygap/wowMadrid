from models.district import District

def get_all_districts_service():
    districts = District.query.all()
    districts_dict = [district.dict() for district in districts]
    return districts_dict