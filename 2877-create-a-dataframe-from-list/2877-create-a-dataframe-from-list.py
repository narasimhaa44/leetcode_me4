import pandas as pd
from typing import List

def createDataframe(student_data: List[List[int]]) -> pd.DataFrame:
    # Create DataFrame from 2D list
    df = pd.DataFrame(student_data, columns=["student_id", "age"])
    return df
