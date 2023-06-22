from flask_toolkits import APIRouter
from flask_toolkits.responses import JSONResponse
from services.event_service import *

event_route = APIRouter('event_route', import_name=__name__)

@event_route.get("/events", tags=["Events"])
def get_all_events():
    response = get_all_events_service()
    return JSONResponse(response)

@event_route.get("/events/district/<string:district>", tags=["Events"])
def get_events_by_district(district):
    events= get_events_by_district_service(district)
    return JSONResponse(events)

@event_route.get("/events/type/<string:event_type>", tags=["Events"])
def get_events_by_type(event_type):
    events= get_events_by_type_service(event_type)
    return JSONResponse(events)