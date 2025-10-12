import pandas as pd

def dropDuplicateEmails(customers: pd.DataFrame) -> pd.DataFrame:
    # Drop duplicates based on the 'email' column, keep the first occurrence
    return customers.drop_duplicates(subset='email', keep='first')