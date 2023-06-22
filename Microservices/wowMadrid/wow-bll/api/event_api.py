from flask_toolkits import APIRouter
from flask_toolkits.responses import JSONResponse
from flask_cors import cross_origin
import requests

event_route = APIRouter('event_route', import_name=__name__)

url= f'http://wow-dao:5000'

@event_route.get('/events')
@cross_origin(supports_credentials=True)
def get_all_events():
    events = requests.get(f'{url}/events', headers={'Access-Control-Allow-Origin': '*'})
    if events.status_code == 200:
        return events.content, events.status_code
    else:
        return JSONResponse({'error': 'Error en la solicitud al microservicio wowDAO'}), events.status_code
    
@event_route.get('/events/district/<string:district>')
@cross_origin(supports_credentials=True)
def get_events_by_district(district):
    events = requests.get(f'{url}/events/district/{district}', headers={'Access-Control-Allow-Origin': '*'})
    if events.status_code == 200:
        return events.content, events.status_code
    else:
        return JSONResponse({'error': 'Error en la solicitud al microservicio wowDAO'}), events.status_code
    
@event_route.get('/events/type/<string:event_type>')
@cross_origin(supports_credentials=True)
def get_events_by_type(type):
    events = requests.get(f'{url}/events/district/{type}', headers={'Access-Control-Allow-Origin': '*'})
    if events.status_code == 200:
        return events.content, events.status_code
    else:
        return JSONResponse({'error': 'Error en la solicitud al microservicio wowDAO'}), events.status_code
  