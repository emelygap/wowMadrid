from flask_toolkits import APIRouter
from flask_toolkits.responses import JSONResponse
from services.district_service import *

district_route = APIRouter('district_route', import_name=__name__)

@district_route.get("/districts", tags=["Districts"])
def get_all_districts():
    response = get_all_districts_service()
    return JSONResponse(response)