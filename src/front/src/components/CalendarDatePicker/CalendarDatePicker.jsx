import * as React from 'react';
import dayjs from 'dayjs';
import { LocalizationProvider } from '@mui/x-date-pickers/LocalizationProvider';
import { AdapterDayjs } from '@mui/x-date-pickers/AdapterDayjs';
import { DateCalendar } from '@mui/x-date-pickers/DateCalendar';
import utc from "dayjs/plugin/utc";
import timezone from "dayjs/plugin/timezone";
dayjs.extend(utc);
dayjs.extend(timezone);


 const CalendarDatePicker = ({handler}) => {

  return (
    <LocalizationProvider dateAdapter={AdapterDayjs}>
      <DateCalendar onChange={handler}/>
    </LocalizationProvider>
  );
}

export default CalendarDatePicker