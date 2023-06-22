from models.event import Event
from models.address import Address
from models.district import District

def get_all_events_service():
    events = Event.query.all()
    events_dict = [event.dict() for event in events]
    return events_dict

def get_events_by_type_service(event_type):
    events = Event.query.filter_by(type=event_type).all()
    events_json = [event.dict() for event in events]
    return events_json
    

def get_events_by_district_service(district):
    events = Event.query.join(Address, Event.address==Address.id).join(District, Address.district==District.id).filter(District.district_name == district).all()
    events_json = [event.dict() for event in events]
    return events_json
    
    