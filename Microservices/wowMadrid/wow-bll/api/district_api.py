from flask_toolkits import APIRouter
from flask_toolkits.responses import JSONResponse
import requests

district_route = APIRouter('district_route', import_name=__name__)

url= f'http://wow-dao:5000'

@district_route.get('/districts')
def get_all_districts():
    districts = requests.get(f'{url}/districts', headers={'Access-Control-Allow-Origin': '*'})
    if districts.status_code == 200:
        return districts.content, districts.status_code
    else:
        return JSONResponse({'error': 'Error en la solicitud al microservicio wowDAO'}), districts.status_code
    